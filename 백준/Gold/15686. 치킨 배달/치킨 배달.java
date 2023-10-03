import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Info {

    int num, mark;

    Info(int num, int mark) {
        this.num = num;
        this.mark = mark;
    }
}

public class Main {

    static Info[][] map;
    static boolean[][] check;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int isValid(int bit) {
        int cnt = 0;

        while (bit > 0) {
            cnt += (bit%2);
            bit = bit/2;
        }

        return cnt;
    }

    static void init() {
        for (int i=0; i< check.length; i++) {
            for (int j=0; j< check[0].length; j++) {
                check[i][j] = false;
            }
        }
    }


    static int bfs(int i, int j, boolean[][] vis) {
        int dist = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            if (map[x][y].num == 2 && check[x][y] == true) {
                dist = Math.abs((i-x)) + Math.abs((j-y));
                return dist;
            }

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length && vis[nx][ny] == false) {
                    vis[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        return dist;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 1. 지도 구현
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        map = new Info[n][n];
        check = new boolean[n][n];

        int cnt = 0;
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                map[i][j] = new Info(Integer.parseInt(line[j]), 0);
                if (map[i][j].num == 2) {
                    map[i][j].mark = (1<<cnt);
                    cnt += 1;
                }
            }
        }

        int ans = -1;
        for (int i=0; i<(1<<cnt); i++) {
            if (isValid(i) != m) continue;

            init();
            int sum = 0;

            for (int j=0; j<cnt; j++) {
                if ((i & (1<<j)) != 0) {
                    for (int l=0; l<n; l++) {
                        for (int z=0; z<n; z++) {
                            if (map[l][z].num == 2 && map[l][z].mark == (1<<j)) {
                                check[l][z] = true;
                            }
                        }
                    }
                }
            }


            for (int l=0; l<n; l++) {
                for (int z=0; z<n; z++) {
                    if (map[l][z].num == 1) {
                        int dist = bfs(l, z, new boolean[n][n]);
                        sum += dist;
                    }
                }
            }

            if (ans == -1 || ans > sum) ans = sum;

        }
        System.out.println(ans);



    }
}