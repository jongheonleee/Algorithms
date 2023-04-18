import java.io.*;

public class Main {

    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        int result = bottomUp(N);
        System.out.println(result);
    }

    public static int bottomUp(int N) {

        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 10007;
        }

        return dp[N];
    }
}