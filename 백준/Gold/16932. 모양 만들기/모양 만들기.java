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
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int[][] a;
    static int[][] group;
    static int[] size;
    static int number;

    static void bfs(int sx, int sy) {
        Queue<Pair> q = new LinkedList<>();
        number += 1;
        
        
        int cnt = 1;
        group[sx][sy] = number;
        q.add(new Pair(sx, sy));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        cnt += 1;
                        group[nx][ny] = number;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        size[number] = cnt;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        group = new int[n][m];
        size = new int[n*m];
        number = 0;

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0) {
                    int res = 1;

                    HashSet<Integer> set = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int nx = i+dx[k], ny = j+dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            if (group[nx][ny] != 0) {
                                set.add(group[nx][ny]);
                            }
                        }
                    }

                    for (int num : set) {
                        res += size[num];
                    }

                    if (res > ans) ans = res;
                }
            }
        }

        System.out.println(ans);


    }
}