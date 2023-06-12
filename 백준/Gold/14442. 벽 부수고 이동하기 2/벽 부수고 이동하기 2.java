import java.util.*;
import java.io.*;

class Pair {
    int x, y, z;

    Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int n;
    static int m;
    static int l;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][][] dist;

    static void bfs(Pair start) {
        Queue<Pair> q = new LinkedList<>();
        dist[start.x][start.y][start.z] = 1;
        q.add(start);

        while (!(q.isEmpty())) {
            Pair p = q.remove();

            int x = p.x, y = p.y, z = p.z;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (!(0 <= nx && nx < n && 0 <= ny && ny < m)) continue;

                if (map[nx][ny] == 0 && dist[nx][ny][z] == 0) {
                    dist[nx][ny][z] = dist[x][y][z] + 1;
                    q.add(new Pair(nx, ny, z));
                }

                if (map[nx][ny] == 1 && z+1 <= l && dist[nx][ny][z+1] == 0) {
                    dist[nx][ny][z+1] = dist[x][y][z] + 1;
                    q.add(new Pair(nx, ny, z+1));
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        l = Integer.parseInt(line1[2]);

        map = new int[n][m];
        dist = new int[n][m][l+1];

        for (int i=0; i<n; i++) {
            String line2 = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = line2.charAt(j) - '0';
            }
        }

        Pair start = new Pair(0, 0, 0);
        bfs(start);

        int ans = -1;

        for (int z=0; z<=l; z++) {
            if (dist[n-1][m-1][z] != 0) {
                if (ans == -1 || ans > dist[n-1][m-1][z]) {
                    ans = dist[n-1][m-1][z];
                }
            }
        }

        System.out.println(ans);

    }
}