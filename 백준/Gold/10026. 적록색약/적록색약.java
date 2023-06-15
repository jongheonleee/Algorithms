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
    static int n;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] map;
    static boolean[][] check;

    static boolean isValid(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n) && check[x][y] == false;
    }
    static boolean isSameColor(int x, int y, int nx, int ny) {
        return (map[x][y] == map[nx][ny]);
    }

    static boolean isRedAndGreen(int x, int y, int nx, int ny) {
        if (map[x][y] == 'B' || map[nx][ny] == 'B') {
            return false;
        } else {
            return true;
        }
    }

    static int bfs(boolean blind) {
        for (int i=0; i<n; i++) {
            Arrays.fill(check[i], false);
        }

        int countParts = 0;
        Queue<Pair> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (check[i][j] == false) {
                    check[i][j] = true;
                    countParts++;
                    q.add(new Pair(i, j));

                    while (!(q.isEmpty())) {
                        Pair p = q.remove();
                        int x = p.x, y = p.y;

                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k], ny = y+dy[k];
                            if (isValid(nx, ny) == false) continue;
                            if (!blind && isSameColor(x, y, nx, ny) == false) continue;
                            if (blind && isSameColor(x, y, nx,ny) == false && isRedAndGreen(x, y, nx, ny) == false) continue;

                            check[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }

        return countParts;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        check = new boolean[n][n];

        // implement map and check
        for (int i=0; i<n; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        int countPartsNotBlind = bfs(false);
        int countPartsBlind = bfs(true);

        System.out.println(countPartsNotBlind + " " + countPartsBlind);

    }
}