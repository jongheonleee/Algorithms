import java.io.*;
import java.util.*;


public class Main {

    static final int MAX = 50 * 20;
    static boolean[] check = new boolean[MAX+1];
    static int[] a = {1, 5, 10, 50};

    static void go(int n, int idx, int num) {
        if (n == 0) {
            check[num] = true;
            return;
        }


        for (int i=idx; i<4; i++) {
            go(n-1, i, num + a[i]);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        go(n, 0, 0);
        int ans = 0;

        for (int i=1; i<=MAX; i++) {
            if (check[i]) ans++;
        }

        System.out.println(ans);


    }
}