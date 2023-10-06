import java.util.*;
import java.io.*;



public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] d = new long[n+1];

        for (int i=1; i<=n; i++) {
            d[i] = d[i-1]+1;
            for (int j=1; j<=i-3; j++) {
                long cnt = d[i-(j+2)] * (j+1);
                if (d[i] < cnt) d[i] = cnt;
            }
        }
        System.out.println(d[n]);

    }
}