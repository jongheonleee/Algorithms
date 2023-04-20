import java.io.*;

public class Main {

    public static int[] dp = new int[10+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        while (T-- != 0) {
            int N = Integer.parseInt(br.readLine());
            int result = bottomUp(N);
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }

    public static int bottomUp(int N) {

        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        return dp[N];
    }

    public static int topDown(int N) {
        if (N <= 2) return dp[N];

        dp[N] = topDown(N-3) + topDown(N-2) + topDown(N-1);

        return dp[N];

    }
}