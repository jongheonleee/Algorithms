import java.util.*;
import java.io.*;

class Person  {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

}


public class Main {

    static Person[] merge(Person[] left, Person[] right) {
        Person[] ans = new Person[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].age <= right[j].age) {
                ans[k++] = left[i++];
            } else {
                ans[k++] = right[j++];
            }
        }

        while (i < left.length) ans[k++] = left[i++];
        while (j < right.length) ans[k++] = right[j++];

        return ans;
    }

    static Person[] merge_sort(Person[] a, int start, int end) {
        if (start == end) {
            Person[] ans = new Person[1];
            ans[0] = a[start];
            return ans;
        }

        int mid = (start+end)/2;
        Person[] left = merge_sort(a, start, mid);
        Person[] right = merge_sort(a, mid+1, end);

        return merge(left, right);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Person[] a = new Person[n];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            int age = Integer.parseInt(line[0]);
            String name = line[1];

            a[i] = new Person(age, name);
        }

        Person[] ans = merge_sort(a, 0, n-1);
        for (Person p : ans) {
            bw.write(p.age + " " + p.name + "\n");
        }
        bw.flush();

    }
}