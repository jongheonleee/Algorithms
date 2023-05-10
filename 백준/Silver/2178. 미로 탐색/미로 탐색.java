import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void bfs(int[][] a, int[][] cnt, int x, int y, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        cnt[x][y] = 1;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x; y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1 && cnt[nx][ny] == -1){
                        q.add(new Pair(nx, ny));
                        cnt[nx][ny] = cnt[x][y]+1;
                    }

                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);

        int[][] a = new int[n][m];
        int[][] cnt = new int[n][m];

        for (int i=0; i<n; i++) {
            String line2 = br.readLine();
            for (int j=0; j<m; j++) {
                a[i][j] = line2.charAt(j) - '0';
                cnt[i][j] = -1;
            }
        }

        bfs(a, cnt, 0, 0, n, m);
        System.out.println(cnt[n-1][m-1]);

    }
}