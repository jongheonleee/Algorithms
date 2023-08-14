import java.util.*;
import java.io.*;



public class Main {

    static int n;
    static int[][] a;
    static long[][][] d;


    static long go(int x, int y, int dir) {
        if (x == n-1 && y == n-1) {
            return 1;
        }
        long ans = d[x][y][dir];
        if (ans != -1) return ans;

        ans = 0;
        if (dir == 0) {
            // 가로 -> 가로, 대각선
            if (0 <= y+1 && y+1 < n && a[x][y+1] == 0) {
                ans += go(x, y+1, 0);
            }

            if (0 <= x+1 && x+1 < n && 0 <= y+1 && y+1 < n &&
                    a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1);
            }
        } else if (dir == 1) {
            // 대각선 -> 가로, 대각선, 세로
            if (0 <= y+1 && y+1 < n && a[x][y+1] == 0) {
                ans += go(x, y+1, 0);
            }

            if (0 <= x+1 && x+1 < n && 0 <= y+1 && y+1 < n &&
                    a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1);
            }

            if (0 <= x+1 && x+1 < n && a[x+1][y] == 0) {
                ans += go(x+1, y, 2);
            }

        } else {
            // 세로 -> 대각선, 세로
            if (0 <= x+1 && x+1 < n && 0 <= y+1 && y+1 < n &&
                    a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1);
            }

            if (0 <= x+1 && x+1 < n && a[x+1][y] == 0) {
                ans += go(x+1, y, 2);
            }
        }

        d[x][y][dir] = ans;
        return ans;



    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n][n];
        d = new long[n][n][3];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(line[j]);
                for (int l=0; l<3; l++) {
                    d[i][j][l] = -1;
                }
            }
        }

        long ans = go(0, 1, 0);
        System.out.println(ans);

    }
}