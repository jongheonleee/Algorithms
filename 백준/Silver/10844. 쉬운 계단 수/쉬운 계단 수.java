import java.io.*;

public class Main {

    static final long mod = 1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] d = new long[n+1][10];
        for (int i=1; i<=9; i++) d[1][i] = 1;

        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                d[i][j] = 0;

                if (j-1 >= 0) d[i][j] += d[i-1][j-1];

                if (j+1 <= 9) d[i][j] += d[i-1][j+1];

                d[i][j] %= mod;
            }
        }

        long result = 0;
        for (int i=0; i<=9; i++) {
            result += d[n][i];
        }

        System.out.println(result%mod);


    }

}