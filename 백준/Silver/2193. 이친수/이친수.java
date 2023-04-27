import java.io.*;

public class Main {

    public static long[][] dp = new long[91][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1][1] = 1;
        dp[2][0] = 1;


        for (int i=3; i<=90; i++) {
            // 마지막 숫자가 0인 경우
            dp[i][0] = dp[i-1][0] + dp[i-1][1];

            // 마지막 숫자가 1인 경우
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);


    }

}