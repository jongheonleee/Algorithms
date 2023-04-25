import java.io.*;


public class Main {
    public static int limit = 100000;
    public static long mod = 1000000009L;
    public static long[][] d = new long[3+1][limit+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        // dp 알고리즘 적용
        for (int i=1; i<=limit; i++) {
            // l이 1이고 적용 가능한 경우
            if (i >= 1) {
                d[1][i] = d[2][i-1] + d[3][i-1];
                d[1][i] %= mod;

                if (i == 1) d[1][i] = 1;
            }

            // l이 2이고 적용 가능한 경우
            if (i >= 2) {
                d[2][i] = d[1][i-2] + d[3][i-2];
                d[2][i] %= mod;

                if (i == 2) d[2][i] = 1;
            }

            // l이 3이고 적용 가능한 경우
            if (i >= 3) {
                d[3][i] = d[1][i-3] + d[2][i-3];
                d[3][i] %= mod;

                if (i == 3) d[3][i] = 1;
            }
        } // 이 시점에서 d의 값들이 다 채워짐

        // 각각의 테스트 케이스 입력받아서 결과값 sb에 저장했다가 한번에 출력하기
        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((d[1][n] + d[2][n] + d[3][n])%mod).append("\n");
        }
        System.out.println(sb);

    }
}