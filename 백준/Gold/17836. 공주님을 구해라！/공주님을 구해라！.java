import java.io.*;
import java.util.*;


class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int wx = -1, wy = -1;

        int[][] map = new int[r][c];
        int[][] dist1 = new int[r][c];
        int[][] dist2 = new int[r][c];

        for (int i=0; i<r; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                dist1[i][j] = -1;
                dist2[i][j] = -1;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        dist1[0][0] = 0;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                    if (map[nx][ny] != 1 && dist1[nx][ny] == -1) {
                        if (map[nx][ny] == 2) {
                            wx = nx; wy = ny;
                        }
                        dist1[nx][ny] = dist1[x][y]+1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        if (wx == -1 && wy == -1) {
            if (dist1[r-1][c-1] != -1 && t >= dist1[r-1][c-1]) {
                System.out.println(dist1[r-1][c-1]);
            } else {
                System.out.println("Fail");
            }
            System.exit(0);
        }

        dist2[wx][wy] = dist1[wx][wy];
        q.add(new Pair(wx, wy));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                    if (dist2[nx][ny] == -1) {
                        dist2[nx][ny] = dist2[x][y]+1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        int tmp1 = dist1[r-1][c-1];
        int tmp2 = dist2[r-1][c-1];
        int res = -1;

        if (tmp1 != -1 && tmp2 != -1) {
            if (tmp1 >= tmp2) {
                res = tmp2;
            } else {
                res = tmp1;
            }
        } else if (tmp1 != -1) {
            res = tmp1;
        } else if (tmp2 != -1) {
            res = tmp2;
        }

        if (res != -1 && res <= t) {
            System.out.println(res);
        } else {
            System.out.println("Fail");
        }
    }
}