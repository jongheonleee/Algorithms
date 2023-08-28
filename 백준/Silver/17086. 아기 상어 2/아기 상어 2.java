import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    static int bfs(int sx, int sy, int[][] a) {
        boolean[][] check = new boolean[a.length][a[0].length];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sx, sy));
        check[sx][sy] = true;
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                Pair p = q.remove();
                int x = p.x;
                int y = p.y;

                if (a[x][y] == 1) return dist;

                for (int k=0; k<8; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if (0 <= nx && nx < a.length && 0 <= ny && ny < a[0].length) {
                        if (check[nx][ny] == true) continue;
                        q.add(new Pair(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }

            dist += 1;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ans = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0) {
                    int dist = bfs(i, j, a);
                    if (ans == -1 || ans < dist) ans = dist;
                }
            }
        }

        System.out.println(ans);
    }
}