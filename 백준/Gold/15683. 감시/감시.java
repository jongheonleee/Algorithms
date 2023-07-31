import java.util.*;
import java.io.*;

class CCTV {
    int x, y, type, dir;

    CCTV(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.dir = 0;
    }
}



public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void check(int[][] a, int[][] b, int x, int y, int dir) {
        int n = a.length, m = a[0].length;
        int i = x, j = y;

        while (0 <= i && i < n && 0 <= j && j < m) {
            if (a[i][j] == 6) break;
            b[i][j] = a[x][y];
            i += dx[dir]; j += dy[dir];
        }
    }

    public static int go(int[][] a, ArrayList<CCTV> cctv, int idx) {
        if (cctv.size() == idx) {
            int n = a.length, m = a[0].length;
            int[][] b = new int[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    b[i][j] = a[i][j];
                }
            }

            for (int i=0; i< cctv.size(); i++) {
                CCTV c = cctv.get(i);
                int x = c.x;
                int y = c.y;
                int what = c.type;
                int dir = c.dir;


                if (what == 1) {
                    check(a, b, x, y, dir);
                } else if (what == 2) {
                    check(a, b, x, y, dir);
                    check(a, b, x, y, (dir+2)%4);
                } else if (what == 3) {
                    check(a, b, x, y, dir);
                    check(a, b, x, y, (dir+1)%4);
                } else if (what == 4) {
                    check(a, b, x, y, dir);
                    check(a, b, x, y, (dir+1)%4);
                    check(a, b, x, y, (dir+2)%4);
                } else {
                    // what == 5
                    check(a, b, x, y, dir);
                    check(a, b, x, y, (dir+1)%4);
                    check(a, b, x, y, (dir+2)%4);
                    check(a, b, x, y, (dir+3)%4);
                }
            }

            int cnt = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (b[i][j] == 0) cnt++;
                }
            }

            return cnt;
        }

        int ans = 100;
        for (int i=0; i<4; i++) {
            cctv.get(idx).dir = i;
            int tmp = go(a, cctv, idx+1);
            if (ans > tmp) ans = tmp;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] a = new int[n][m];
        ArrayList<CCTV> cctv = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                a[i][j] = Integer.parseInt(input[j]);
                if (1 <= a[i][j] && a[i][j] <= 5) {
                    cctv.add(new CCTV(i, j, a[i][j]));
                }
            }
        }

        System.out.println(go(a, cctv, 0));
    }
}