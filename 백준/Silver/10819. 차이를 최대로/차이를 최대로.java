import java.io.*;
import java.util.*;
public class Main {

    static int[] a = new int[10];
    public static boolean next_permutation(int[] a, int n) {
        int i = n-1;
        while (i>0 && a[i-1] >= a[i]) i--;

        if (i <= 0) return false;

        int j = n-1;
        while (a[i-1] >= a[j]) j--;

        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        j = n-1;
        while(i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;
            i++; j--;
        }

        return true;
    }

//    public static boolean previous_permutation(int[] a) {
//        int i = a.length-1;
//        while (i>0 && a[i-1] <= a[i]) i--;
//
//        if (i <= 0) return false;
//
//        int j = a.length-1;
//        while (a[i-1] <= a[j]) j--;
//
//        int tmp = a[i-1];
//        a[i-1] = a[j]; a[j] = tmp;
//
//        j = a.length-1;
//        while(i < j) {
//            tmp = a[i];
//            a[i] = a[j]; a[j] = tmp;
//            i++; j--;
//        }
//
//        return true;
//    }
    public static int calculate(int n) {
        int sum = 0;
        for (int i=1; i<n; i++) {
            sum += Math.abs(a[i-1] - a[i]);
        }

        return sum;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        int max = 0;
        Arrays.sort(a, 0, n);
        do {
            max = Math.max(max, calculate(n));
        } while (next_permutation(a, n));

        System.out.println(max);

    }
}