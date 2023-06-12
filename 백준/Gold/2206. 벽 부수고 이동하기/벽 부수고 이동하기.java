import java.io.*;
import java.util.*;

class Pair {
    int x, y, z;

    Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int n;
    static int m;

    static int[][][] dist;
    static int[][] map;

    static boolean can(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    static void getResult() {
        if (dist[n-1][m-1][0] != 0 && dist[n-1][m-1][1] != 0) {
            System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        } else if (dist[n-1][m-1][0] != 0) {
            System.out.println(dist[n-1][m-1][0]);
        } else if (dist[n-1][m-1][1] != 0) {
            System.out.println(dist[n-1][m-1][1]);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(Pair start) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        dist[start.x][start.y][start.z] = 1;

        while (!(q.isEmpty())) {
            Pair p = q.remove();

            int x = p.x; int y = p.y; int z = p.z;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (can(nx, ny) == false) continue;

                if (map[nx][ny] == 0 && dist[nx][ny][z] == 0) {
                    q.add(new Pair(nx, ny, z));
                    dist[nx][ny][z] = dist[x][y][z] + 1;
                }
                if (map[nx][ny] == 1 && z == 0 && dist[nx][ny][z+1] == 0) {
                    q.add(new Pair(nx, ny, z+1));
                    dist[nx][ny][z+1] = dist[x][y][z] + 1;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        
        // 세팅값
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        map = new int[n][m];
        dist = new int[n][m][2];

        // 지도 구현하기
        for (int i=0; i<n; i++) {
            String line2 = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = line2.charAt(j) - '0';
            }
        }

        Pair start = new Pair(0, 0, 0);
        bfs(start);
        getResult();
    }
}