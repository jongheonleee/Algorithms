import java.util.*;
import java.io.*;



public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];
        int[][] items = new int[n+1][2];
        for (int i=1; i<=n; i++) {
            String[] line = br.readLine().split(" ");
            int w = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            items[i][0] = w;
            items[i][1] = v;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=k; j++) {
                dp[i][j] = dp[i-1][j];

                if (j >= items[i][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-items[i][0]] + items[i][1]);
                }
            }
        }

        System.out.println(dp[n][k]);


    }
}