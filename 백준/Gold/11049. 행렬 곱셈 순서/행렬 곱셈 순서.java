import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;




public class Main {


    public static void main(String[] args) throws IOException {
        // 0. 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];
        int[][] map = new int[n][2];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(line[0]);
            map[i][1] = Integer.parseInt(line[1]);
        }

        // 1. dp 알고리즘 적용
            // dp 정의 : dp[i][j] i~j까지의 최소 연산 memo
            // 탐색범위 : k -> 1 ~ n, i -> 0 ~ n-k, j -> 0 ~ n-k
        for (int k=1; k<n; k++) {
            for (int i=0; i+k<n; i++) {
                dp[i][i+k] = Integer.MAX_VALUE;

                for (int j=i; j<i+k; j++) {
                    dp[i][i+k] = Math.min(
                            dp[i][i+k],
                            dp[i][j]+dp[j+1][i+k]+(map[i][0] * map[j][1] * map[i+k][1])
                    );
                }
            }
        }

        // 2. 결과 출력

        System.out.println(dp[0][n-1]);
    }
}