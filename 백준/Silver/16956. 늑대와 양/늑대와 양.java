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

    static int r, c, ans;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][] check;

    static boolean validate(int x, int y) {
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                if (map[nx][ny] == 'S') {
                    return false;
                }
            }
        }

        return true;
    }

    static void bfs(int i, int j) {
        Queue<Pair> q = new LinkedList<>();

        check[i][j] = true;
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                    if (map[nx][ny] == 'S') {
                        continue;
                    }
                    if (check[nx][ny] == false && map[nx][ny] == '.') {
                        check[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    static void show() {
        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n");
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        check = new boolean[r][c];

        for (int i=0; i<r; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (map[i][j] == 'W' && check[i][j] == false) {
                    if (validate(i, j)) {
                        bfs(i, j);
                    } else {
                        System.out.println(0);
                        System.exit(0);
                    }
                }
            }
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (check[i][j] == true && map[i][j] == '.') {
                    map[i][j] = 'D';
                }
            }
        }


        show();
    }
}