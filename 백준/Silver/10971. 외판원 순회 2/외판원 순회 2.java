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

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] w = new int[n][n];
        for (int i=0; i<n; i++) {
            a[i] = i;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        int min = Integer.MAX_VALUE;

        do {
            boolean ok = true;
            int tmp = 0;
            for (int i=0; i<n-1; i++) {
                if (w[a[i]][a[i+1]] == 0) {
                    ok = false;
                } else {
                    tmp += w[a[i]][a[i+1]];
                }
            }
            if (ok && w[a[n-1]][a[0]] != 0) {
                tmp += w[a[n-1]][a[0]];
            } else {
                ok = false;
            }

            if (ok) {
                min = Math.min(min, tmp);
            }

        } while (next_permutation(a, n));
        System.out.println(min);

    }
}