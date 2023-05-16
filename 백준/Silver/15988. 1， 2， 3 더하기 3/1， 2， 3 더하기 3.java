import java.util.*;
import java.io.*;

public class Main {

    static final long MOD = 1000000009L;
    static final int LIMIT = 1000001;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[] d = new long[LIMIT];

        d[0] = 1; d[1] = 1; d[2] = 2;
        for (int i=3; i<LIMIT; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
            d[i] %= MOD;
        }


        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(d[n]%MOD).append("\n");
        }
        System.out.println(sb);

    }
}