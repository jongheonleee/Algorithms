import java.io.*;

public class Main {

    static int mod = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[3][n+1];

        // dp 기초 세팅값
        for (int p=0; p<=2; p++) d[p][1] = 1;

        // dp 알고리즘 적용
        for (int i=2; i<=n; i++) {
            d[0][i] = d[0][i-1] + d[1][i-1] + d[2][i-1];
            d[1][i] = d[0][i-1] + d[2][i-1];
            d[2][i] = d[0][i-1] + d[1][i-1];

            for (int p=0; p<=2; p++) d[p][i] %= mod;
        }

        System.out.println((d[0][n] + d[1][n] + d[2][n])%mod);

    }
}