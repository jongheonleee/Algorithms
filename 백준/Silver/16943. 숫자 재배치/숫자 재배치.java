import java.io.*;
import java.util.*;


public class Main {

    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i>0 && a[i-1] >= a[i]) i--;

        if (i<=0) return false;

        int j = a.length-1;
        while (a[j] <= a[i-1]) j--;

        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        j = a.length-1;
        while (i<j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;
            i++; j--;
        }

        return true;
    }

    static int convert(int[] a) {
        int n = 0;

        for (int i=0; i<a.length; i++) {
            n = n*10 + a[i];
        }

        return n;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int[] a = new int[line[0].length()];
        for (int i=0; i<line[0].length(); i++) {
            a[i] = line[0].charAt(i) - '0';
        }
        Arrays.sort(a);
        int b = Integer.parseInt(line[1]), c = -1;

        do {
            int k = convert(a);
            if (a[0] != 0 && k < b) c = k;
        } while (next_permutation(a));

        System.out.println(c);
    }
}