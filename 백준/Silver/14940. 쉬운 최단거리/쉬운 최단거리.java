import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 *
 * 모든 지점에 대해서 목표지점까지의 거리 구하기
 * 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점
 *
 **/
public class Main {

    /**
     * bfs
     * 시작점 찾기
     * bfs 적용 및 최단거리 기록
     * 결과 출력
     *
     **/

    static int n, m;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][] dist;

    private static Point findSrc(int mark) {
        int x = 0, y = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == mark) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        return new Point(x, y);
    }

    private static void bfs(Point src) {
        // bfs 적용
        Queue<Point> q = new LinkedList<>();
        q.add(src);
        dist[src.x][src.y] = 0;

        while (!q.isEmpty()) {
            Point curr = q.remove();
            int x = curr.x;
            int y = curr.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (!(0 <= nx && nx < n && 0 <= ny && ny < m)) continue;
                if (dist[nx][ny] != -1) continue;
                if (map[nx][ny] == 0) continue;

                Point next = new Point(nx, ny);
                q.add(next);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }


        // 최단거리 기록
    }

    private static void printDist() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 입력 받기 및 구현
            // n, m, 지도 구현
            // 지도 초기화
            // 최단거리 기록 공간 생성 및 초기화
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        map = new int[n][m];
        dist = new int[n][m];

        for (int i=0; i<n; i++) {
            line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                dist[i][j] = map[i][j] == 0 ? 0 : -1;
            }
        }

        // 1. 시작점 찾기
        Point src = findSrc(2);

        // 2. bfs 알고리즘 적용 및 최단 거리 기록
        bfs(src);

        // 3. 결과 출력
        printDist();

    }
}