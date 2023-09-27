import java.util.*;
import java.io.*;




public class Main {

    static final int MAX = 10_000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();

            int[][] dp = new int[MAX+1][3+1];

            // init
            dp[1][1] = 1;
            dp[2][1] = 1; dp[2][2] = 1;
            dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

            // working
            for (int i=4; i<=n; i++) {
                // last number is 1
                dp[i][1] = dp[i-1][1];

                // last number is 2
                dp[i][2] = dp[i-2][1] + dp[i-2][2];

                // last number is 3
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }

            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);

        }
     }
}