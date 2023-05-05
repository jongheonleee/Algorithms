import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), k = Integer.parseInt(line[1]);
        long[][] d = new long[k+1][n+1];

        // 초기 세팅값
        for (int i=0; i<=n; i++) {
            d[1][i] = 1;
        }

        // 알고리즘 적용
        for (int i=2; i<=k; i++) {
            for (int j=0; j<=n; j++) {
                for (int l=0; l<=j; l++) {
                    d[i][j] += d[i-1][l];
                }
                d[i][j] %= mod;
            }
        }
        System.out.println(d[k][n]);


    }
}