import java.util.*;
import java.io.*;



public class Main {

    static int[] d;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[n+1];
        for (int i=1; i<=n; i++) {
            int val = Integer.parseInt(br.readLine());
            v[i] = val;
        }

        d = new int[k+1];
        d[0] = 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=k; j++) {
                if (j-v[i] < 0) continue;
                d[j] += d[j-v[i]];
            }
        }
        System.out.println(d[k]);
    }
}
