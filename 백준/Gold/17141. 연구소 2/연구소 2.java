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

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean validate(int bit, int m) {
        while (bit > 0) {
            int left = bit%2;
            if (left == 1) m -= 1;
            bit = bit >> 1;
        }

        return m == 0;
    }

    static int calc(int[][] laboratory, int[][] dist) {
        boolean ok = true;
        int max = 0;

        for (int i=0; i<laboratory.length; i++) {
            for (int j=0; j<laboratory[0].length; j++) {
                if (laboratory[i][j] != 1 && dist[i][j] == -1) ok = false;
                if (max < dist[i][j]) max = dist[i][j];
            }
        }

        return ok == true ? max : -1;
    }

    static int[][] bfs(ArrayList<Pair> store, int[][] laboratory) {
        int[][] dist = new int[laboratory.length][laboratory[0].length];
        for (int i=0; i<dist.length; i++) {
            for (int j=0; j<dist[0].length; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        for (Pair selected : store) {
            int x = selected.x;
            int y = selected.y;
            q.add(new Pair(x, y));
            dist[x][y] = 0;
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (0 <= nx && nx < laboratory.length && 0 <= ny && ny < laboratory[0].length) {
                    if (laboratory[nx][ny] != 1 && dist[nx][ny] == -1) {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }

        return dist;
    }


    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Pair> candidates = new ArrayList<>();
        int[][] laboratory = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                laboratory[i][j] = sc.nextInt();
                if (laboratory[i][j] == 2) {
                    candidates.add(new Pair(i, j));
                }
            }
        }

        int ans = -1;
        for (int i=0; i<(1<<candidates.size()); i++) {
            if (validate(i, m)) {
                ArrayList<Pair> store = new ArrayList<>();
                for (int j=0; j<candidates.size(); j++) {
                    if ((i&(1<<j)) != 0) {
                        store.add(candidates.get(j));
                    }
                }
                

                int[][] dist = bfs(store, laboratory);
                int tmp = calc(laboratory, dist);
                if (tmp != -1 && (ans == -1 || ans > tmp)) {
                    ans = tmp;
                }
            }
        }

        System.out.println(ans);



    }

}