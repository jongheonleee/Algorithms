import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class State {
    int x, y, t;

    State(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class Main {

    static int[] dx = {0, 0, 1, -1, -2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 0, 0, 1, -1, 2, -2, 2, -2, 1, -1};
    static int[] cost = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[][] map = new int[h][w];
        int[][][] d = new int[h][w][k+1];

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                Arrays.fill(d[i][j], -1);
            }
        }

        Queue<State> q = new LinkedList<>();
        d[0][0][0] = 0;
        q.add(new State(0, 0, 0));

        while (!q.isEmpty()) {
            State s = q.remove();
            int x = s.x;
            int y = s.y;
            int t = s.t;

            for (int l=0; l<12; l++) {
                int nx = x+dx[l];
                int ny = y+dy[l];
                int nt = t+cost[l];

                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (nt > k) continue;
                    if (map[nx][ny] == 1) continue;
                    if (d[nx][ny][nt] != -1) continue;

                    d[nx][ny][nt] = d[x][y][t] + 1;
                    q.add(new State(nx, ny, nt));
                }
            }
        }

        int ans = -1;
        for (int i=0; i<=k; i++) {
            if (d[h-1][w-1][i] != -1) {
                if (ans == -1 || ans > d[h-1][w-1][i]) {
                    ans = d[h-1][w-1][i];
                }
            }
        }

        System.out.println(ans);
    }
}