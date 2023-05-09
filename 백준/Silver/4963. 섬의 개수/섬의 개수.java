import java.util.*;
import java.io.*;


class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    public static final int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static final int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    public static void bfs(int[][] a, int[][] g, int x, int y, int cnt, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        g[x][y] = cnt;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x; y = p.y;

            for (int k=0; k<8; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        g[nx][ny] = cnt;
                    }
                }
            }
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] line1 = br.readLine().split(" ");
            int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]);

            if (n == 0 && m == 0) break;

            int[][] a = new int[m][n];
            for (int i=0; i<m; i++) {
                String[] line2 = br.readLine().split(" ");
                for (int j=0; j<n; j++) {
                    a[i][j] = Integer.parseInt(line2[j]);
                }
            }

            int cnt = 0;
            int[][] g = new int[m][n];
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (a[i][j] == 1 && g[i][j] == 0) {
                        bfs(a, g, i, j, ++cnt, n, m);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}