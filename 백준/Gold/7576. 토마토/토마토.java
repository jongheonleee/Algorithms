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

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        int m = Integer.parseInt(line1[0]), n = Integer.parseInt(line1[1]);
        int[][] a = new int[n][m];
        int[][] d = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            String[] line2 = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                a[i][j] = Integer.parseInt(line2[j]);
                d[i][j] = -1;

                if (a[i][j] == 1) {
                    q.add(new Pair(i, j));
                    d[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x; int y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 0 && d[nx][ny] == -1) {
                        q.add(new Pair(nx, ny));
                        d[nx][ny] = d[x][y] + 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (ans < d[i][j]) {
                    ans = d[i][j];
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && d[i][j] == -1) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);

    }
}