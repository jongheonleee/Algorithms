import java.util.*;
import java.io.*;


public class Main {

    static final int IMPOSSIBLE = -1;

    static int[][] A;
    static int[][] B;

    static void flip(int x, int y) {
        for (int i=x; i<=x+2; i++) {
            for (int j=y; j<=y+2; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);

        A = new int[n][m];
        B = new int[n][m];

        // implements A & B
        for (int i=0; i<n; i++) {
            String lineA = br.readLine();
            for (int j=0; j<m; j++) {
                A[i][j] = lineA.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            String lineB = br.readLine();
            for (int j=0; j<m; j++) {
                B[i][j] = lineB.charAt(j) - '0';
            }
        }

        int ans = 0;
        // greedy
        for (int i=0; i<n-2; i++) {
            for (int j=0; j<m-2; j++) {
                if (A[i][j] != B[i][j]) {
                    ans++;
                    flip(i, j);
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (A[i][j] != B[i][j]) {
                    System.out.println(IMPOSSIBLE);
                    System.exit(0);
                }
            }
        }

        System.out.println(ans);
    }

}