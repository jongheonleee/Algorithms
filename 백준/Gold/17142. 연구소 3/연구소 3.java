import java.util.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int row, col, m, ans;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] laboratory;
    static ArrayList<Pair> candidates = new ArrayList<>();
    static boolean[] selected;

    static void select(int index, int count) {
        if (index == candidates.size()) {
            if (count == m) {
                bfs();
            }
            return;
        }

        selected[index] = true;
        select(index+1, count+1);

        selected[index] = false;
        select(index+1, count);
    }

    static void bfs() {
        int[][] dist = new int[row][col];
        for (int i=0; i<row; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<candidates.size(); i++) {
            if (selected[i] == true) {
                Pair p = candidates.get(i);
                int x = p.x;
                int y = p.y;

                dist[x][y] = 0;
                q.add(new Pair(x, y));
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();

            int x = p.x;
            int y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (!(0 <= nx && nx < row && 0 <= ny && ny < col)) continue;
                if (laboratory[nx][ny] != 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y]+1;
                    q.add(new Pair(nx, ny));
                }

            }
        }

        int res = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (laboratory[i][j] == 0) {
                    if (dist[i][j] == -1) return;
                    if (res < dist[i][j]) res = dist[i][j];
                }
            }
        }

        if (ans == -1 || ans > res) ans = res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = col = sc.nextInt();
        m = sc.nextInt();
        ans = -1;
        laboratory = new int[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                laboratory[i][j] = sc.nextInt();

                if (laboratory[i][j] == 2) {
                    candidates.add(new Pair(i, j));
                }
            }
        }
        selected = new boolean[candidates.size()];
        select(0, 0);
        System.out.println(ans);

    }
}