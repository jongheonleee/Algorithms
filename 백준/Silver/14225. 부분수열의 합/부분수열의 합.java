import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[] a;
    static boolean[] check = new boolean[20 * 100000 + 10];
    static void go(int i, int sum) {
        if (i == n) {
            check[sum] = true;
            return;
        }

        go(i+1, sum+a[i]);
        go(i+1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        go(0, 0);

        for (int i=1;;i++) {
            if (!check[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}