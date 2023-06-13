import java.io.*;
import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {
    static int n;
    static int m;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] map;
    static int[][] water;
    static int[][] dist;

    static boolean can(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        water = new int[n][m];
        dist = new int[n][m];


        Queue<Point> q1 = new LinkedList<>();
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i=0; i<n; i++) {
            String input = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = input.charAt(j);
                dist[i][j] = -1;
                water[i][j] = -1;

                if (map[i][j] == 'D') {
                    ex = i; ey = j;
                }
                else if (map[i][j] == 'S') {
                    sx = i; sy = j;
                }
                else if (map[i][j] =='*') {
                    water[i][j] = 0;
                    q1.add(new Point(i, j));
                }
            }
        }

        // (r, c)에 물이 차는 경우 구하기
        while (!(q1.isEmpty())) {
            Point p = q1.remove();

            int x = p.x;
            int y = p.y;

            // 물, 이동할 수 없는 거 D, X
            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (can(nx, ny) == false) continue;
                if (map[nx][ny] == 'D' || map[nx][ny] == 'X' || water[nx][ny] != -1) continue;

                water[nx][ny] = water[x][y] + 1;
                q1.add(new Point(nx, ny));
            }
        }

        Queue<Point> q2 = new LinkedList<>();
        q2.add(new Point(sx, sy));
        dist[sx][sy] = 0;

        while (!(q2.isEmpty())) {
            Point p = q2.remove();

            int x = p.x;
            int y = p.y;

            if (x == ex && y == ey) {
                System.out.println(dist[ex][ey]);
                System.exit(0);
            }

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (can(nx, ny) == false) continue;
                if (map[nx][ny] == 'X' || (water[nx][ny] != -1 && dist[x][y] + 1 >= water[nx][ny]) || dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q2.add(new Point(nx, ny));
            }

        }

        System.out.println("KAKTUS");


    }

}