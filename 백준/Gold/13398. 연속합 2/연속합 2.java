import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[n];
        int[][] d = new int[n][2];
        
        for (int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        int max = a[0];
        d[0][0] = a[0]; d[0][1] = a[0];
        
        for (int i=1; i<n; i++) {
            d[i][0] = Math.max(d[i-1][0] + a[i], a[i]);
            d[i][1] = Math.max(d[i-1][0], d[i-1][1] + a[i]);
            max = Math.max(max, Math.max(d[i][0], d[i][1]));
        }

        System.out.println(max);

    }
}