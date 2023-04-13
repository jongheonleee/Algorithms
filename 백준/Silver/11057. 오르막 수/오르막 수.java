import java.io.*;

public class Main {

    static int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[9+1][n+1];

        for (int l=0; l<=9; l++) d[l][1] = 1;

        long acc;
        for (int i=2; i<=n; i++) {
            acc = 0L;
            for (int l=0; l<=9; l++) {
                acc += d[l][i-1];
                d[l][i] = acc%mod;
            }
        }

        long result = 0L;
        for (int l=0; l<=9; l++) result += d[l][n];
        
        System.out.println(result%mod);

    }
}