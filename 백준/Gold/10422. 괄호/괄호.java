import java.util.*;
import java.io.*;



public class Main {

    static final int LIMIT = 5_000;
    static final long MOD = 1_000_000_007L;

    static long[] d;

    static long go(int n) {
        if (n == 0){
            return 1;
        } else if (d[n] >= 0) {
            return d[n];
        }

        d[n] = 0;
        for (int i=2; i<=n; i+=2) {
            d[n] += go(i-2) * go(n-i);
            d[n] %= MOD;
        }

        return d[n];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());


        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n%2 == 0) {
                d = new long[LIMIT+1];
                Arrays.fill(d, -1);

                long ans = go(n);
                System.out.println(ans%MOD);
            } else {
                System.out.println(0);
            }

        }

    }
}

