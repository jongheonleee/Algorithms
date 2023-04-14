import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] t = new int[n][n], d = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<=i; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d[0][0] = t[0][0];
        for (int i=1; i<n; i++) {
            for (int j=0; j<=i; j++) {
                if (j == 0) {
                    d[i][j] = t[i][j] + d[i-1][0];
                }
                else if (j == i) {
                    d[i][j] = t[i][j] + d[i-1][j-1];
                }
                else {
                    d[i][j] = t[i][j] + Math.max(d[i-1][j-1], d[i-1][j]);
                }

            }
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            if (result < d[n-1][i]) result = d[n-1][i];
        }

        System.out.println(result);

    }
}