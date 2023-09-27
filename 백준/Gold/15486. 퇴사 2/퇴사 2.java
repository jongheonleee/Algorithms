import java.util.*;
import java.io.*;




public class Main {

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] table = new int[n][2];

            for (int i=0; i<n; i++) {
                table[i][0] = sc.nextInt();
                table[i][1] = sc.nextInt();
            }

            int[] dp = new int[n+50];
            for (int i=0; i<n; i++) {
                // o
                dp[i+table[i][0]] = Math.max(dp[i+table[i][0]], dp[i] + table[i][1]);
                // x
                dp[i+1] = Math.max(dp[i+1], dp[i]);
            }

            System.out.println(dp[n]);
        }
}