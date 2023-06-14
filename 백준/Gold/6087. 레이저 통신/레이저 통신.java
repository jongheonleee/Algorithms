import java.util.*;
import java.io.*;

class Point {
    int x, y;

    Point(int x, int y){
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
    static int[][] numberOfLine;

    static boolean isValid(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    static int bfs(Point start, Point end) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        numberOfLine[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Point p = q.remove();

            int x = p.x, y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                while (isValid(nx, ny) == true) {
                    if (map[nx][ny] == '*') break;
                    if (numberOfLine[nx][ny] == -1) {
                        numberOfLine[nx][ny] = numberOfLine[x][y] + 1;
                        q.add(new Point(nx, ny));
                    }
                    nx+=dx[k];
                    ny+=dy[k];
                }
            }
        }
        return numberOfLine[end.x][end.y] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        numberOfLine = new int[n][m];

        // 초기 세팅
        for (int i=0; i<n; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
            Arrays.fill(numberOfLine[i], -1);
        }

        int sx = -1, sy = -1, ex = -1, ey = -1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 'C') {
                    if (sx == -1) {
                        sx = i; sy = j;
                    }
                    else {
                        ex = i; ey = j;
                    }
                }

            }
        }

        int countOfMirror = bfs(new Point(sx, sy), new Point(ex, ey));
        System.out.println(countOfMirror);
    }
}