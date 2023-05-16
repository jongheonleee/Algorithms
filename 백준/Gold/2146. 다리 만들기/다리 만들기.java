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

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n]; // 인접 행렬
        int[][] g = new int[n][n]; // 그룹 번호 저장
        int[][] d = new int[n][n]; // 거리 저장

        // 인접 행렬 구현하기
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");

            for (int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }

        int num = 0;
        // 그룹 번호 매겨주기
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 1 && g[i][j] == 0) {
                    Queue<Pair> q = new LinkedList<>();
                    g[i][j] = ++num;
                    q.add(new Pair(i, j));

                    while (!q.isEmpty()) {
                        Pair p = q.remove();
                        int x = p.x; int y = p.y;

                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k]; int ny = y+dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                                    g[nx][ny] = num;
                                    q.add(new Pair(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }

        // 각 그룹(섬)에서 다른 그룹(섬)으로 연결하는데 걸리는 거리 구하기
        int ans = -1;
        for (int l=1; l<=num; l++) {
            Queue<Pair> q = new LinkedList<>();

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    d[i][j] = -1;

                    if (g[i][j] == l) {
                        q.add(new Pair(i, j));
                        d[i][j] = 0;
                    }
                }
            }

            while (!q.isEmpty()) {
                Pair p = q.remove();
                int x = p.x; int y = p.y;

                for (int k=0; k<4; k++) {
                    int nx = x+dx[k]; int ny = y+dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (d[nx][ny] == -1 && g[nx][ny] != l) {
                            d[nx][ny] = d[x][y] + 1;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (a[i][j] == 1 && g[i][j] != l) {
                        if (ans == -1 || ans > d[i][j]-1) {
                            ans = d[i][j]-1;
                        }
                    }
                }
            }

        }
        System.out.println(ans);

    }
}