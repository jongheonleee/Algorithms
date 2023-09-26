import java.util.*;
import java.io.*;




public class Main {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            dp[i] = -1;
        }

        dp[0] = 0;
        for (int i=0; i<n; i++) {
            if (dp[i] == -1) continue;
            for (int k=1; k<=a[i]; k++) {
                if (i+k < n) {
                    if (dp[i+k] == -1) {
                        dp[i+k] = dp[i]+1;
                    } else {
                        dp[i+k] = Math.min(dp[i]+1, dp[i+k]);
                    }
                }
            }
        }

        System.out.println(dp[n-1]);
     }
}