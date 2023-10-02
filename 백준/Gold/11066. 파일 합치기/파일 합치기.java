import java.util.*;
import java.io.*;



public class Main {

    static int[] a;
    static int[][] dp;

    static int go(int i, int j) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = -1;
        int sum = 0;
        for (int k=i; k<=j; k++) {
            sum += a[k];
        }

        for (int k=i; k<j; k++) {
            int tmp = go(i, k) + go(k+1, j) + sum;
            if (ans == -1 || ans > tmp) ans = tmp;
        }

        dp[i][j] = ans;
        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] numberStr = br.readLine().split(" ");

            a = new int[n+1];
            dp = new int[n+1][n+1];

            for (int i=1; i<=n; i++) {
                a[i] = Integer.parseInt(numberStr[i-1]);
                Arrays.fill(dp[i], -1);
            }

            int ans = go(1, n);
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}
