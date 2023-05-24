import java.util.*;
import java.io.*;

public class Main {

    static int[] a;

    static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j]; a[j] = tmp;
    }

    static void reverse(int i) {
        int j = a.length-1;

        while (i < j) {
            int tmp = a[i];
            a[i] = a[j]; a[j] = tmp;
            i++; j--;
        }
    }

    static boolean next_permutation() {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i])
            i--;

        if (i <= 0) return false;

        int j = a.length-1;
        while (j > i && a[i-1] >= a[j])
            j--;

        swap(i-1, j);
        reverse(i);

        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        if (next_permutation()) {
            for (int i=0; i<n; i++) {
                sb.append(a[i]).append(" ");
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);

    }
}