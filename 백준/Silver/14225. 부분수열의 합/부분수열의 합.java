import java.util.*;
import java.io.*;
public class Main {
    static int LIMIT = 2000000;

    static boolean[] check = new boolean[LIMIT+1];

    static void go(int[] a, int idx, int sum) {
        if (idx == a.length) {
            check[sum] = true;
            return;
        }

        go(a, idx+1, sum+a[idx]);
        go(a, idx+1, sum);

    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int[] a = new int[n];

        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }


        go(a, 0, 0);

        for (int i=1; i<=LIMIT; i++) {
            if (check[i] == false) {
                System.out.println(i);
                break;
            }
        }

    }
}