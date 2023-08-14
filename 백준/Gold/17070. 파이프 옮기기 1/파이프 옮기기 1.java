import java.util.*;
import java.io.*;



public class Main {


    static int go(int x, int y, int dir, int[][] a) {
        if (x == a.length-1 && y == a[0].length-1) {
            return 1;
        }
        int ans = 0;
        a[x][y] = 1;

        if (dir == 0) {
            // 가로 -> 가로, 대각선
            if (0 <= y+1 && y+1 < a[0].length && a[x][y+1] == 0) {
                ans += go(x, y+1, 0, a);
            }

            if (0 <= x+1 && x+1 < a.length && 0 <= y+1 && y+1 < a[0].length &&
                    a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1, a);
            }
        } else if (dir == 1) {
            // 대각선 -> 가로, 대각선, 세로
            if (0 <= y+1 && y+1 < a[0].length && a[x][y+1] == 0) {
                ans += go(x, y+1, 0, a);
            }

            if (0 <= x+1 && x+1 < a.length && 0 <= y+1 && y+1 < a[0].length &&
                    a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1, a);
            }

            if (0 <= x+1 && x+1 < a.length && a[x+1][y] == 0) {
                ans += go(x+1, y, 2, a);
            }

        } else {
            // 세로 -> 대각선, 세로
            if (0 <= x+1 && x+1 < a.length && 0 <= y+1 && y+1 < a[0].length &&
                    a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1, a);
            }

            if (0 <= x+1 && x+1 < a.length && a[x+1][y] == 0) {
                ans += go(x+1, y, 2, a);
            }
        }


        a[x][y] = 0;
        return ans;



    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = go(0, 1, 0, a);
        System.out.println(ans);

    }
}