import java.util.*;
import java.io.*;

public class Main {


    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i])
            i--;

        if (i <= 0) return false;

        int j = a.length-1;
        while (j > i && a[i-1] >= a[j])
            j--;

        // swap
        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        // reverse
        j=a.length-1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;

            i++; j--;
        }

        return true;
    }

    static boolean check(int[] p, char[] a) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == '<' && p[i] > p[i+1]) {
                return false;
            }
            if (a[i] == '>' && p[i] < p[i+1]) {
                return false;
            }
        }

        return true;
    }

    static boolean prev_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] <= a[i])
            i--;

        if (i <= 0) return false;

        int j = a.length-1;
        while (j > i && a[i-1] <= a[j])
            j--;

        // swap
        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        // reverse
        j = a.length-1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;

            i++; j--;
        }

        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        char[] a = new char[k];

        String[] line = br.readLine().split(" ");
        for (int i=0; i<k; i++) {
            a[i] = line[i].charAt(0);
        }

        int[] small = new int[k+1];
        int[] big = new int[k+1];

        for (int i=0; i<=k; i++) {
            small[i] = i;
            big[i] = 9-i;
        }

        do {
            if (check(small, a)) {
                break;
            }
        } while (next_permutation(small));

        do {
            if (check(big, a)) {
                break;
            }
        } while (prev_permutation(big));

        for (int i=0; i<=k; i++) {
            sb.append(big[i]);
            if (i == k) {
                sb.append("\n");
            }
        }


        for (int i=0; i<=k; i++) {
            sb.append(small[i]);
            if (i == k) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}