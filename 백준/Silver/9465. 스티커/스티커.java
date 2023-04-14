import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t--!=0) {
            int n = Integer.parseInt(br.readLine());
            int[][] s = new int[2][n+1];


            for (int i=0; i<=1; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for (int j=1; j<=n; j++) s[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] d = new int[2][n+1];
            d[0][1] = s[0][1];
            d[1][1] = s[1][1];
            // 0 위 스티커는 max(maxUp0, maxDown0), 1 아래 스티커는 max(maxUp1, maxDown1)
            int maxUp0 = 0, maxUp1 = d[0][1], maxDown0 = d[1][1], maxDown1 = 0;

            // dp 알고리즘 적용
            // i 번째
            for (int i=2; i<=n; i++) {
                // 0 :위 스티커
                d[0][i] = maxUp0 > maxDown0 ? s[0][i] + maxUp0 : s[0][i] + maxDown0;

                // 1 : 아래 스티커
                d[1][i] = maxUp1 > maxDown1 ? s[1][i] + maxUp1 : s[1][i] + maxDown1;


                if ( maxUp0 < d[0][i-1]) maxUp0 = d[0][i-1];
                if ( maxDown0 < d[1][i]) maxDown0 = d[1][i];
                if ( maxUp1 < d[0][i]) maxUp1 = d[0][i];
                if ( maxDown1 < d[1][i-1]) maxDown1 = d[1][i-1];

            }


            // 최대값 찾기
            int result = 0;
            for (int i=1; i<=n; i++) {
                if (result < d[0][i]) result = d[0][i];
                if (result < d[1][i]) result = d[1][i];
            }

            // 출력값 저장하기
            sb.append(result).append("\n");

        }
        // 출력하기
        System.out.println(sb);
    }
}