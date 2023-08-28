import java.util.*;
class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    static int[][] bfs(String[] map, int sx, int sy) {
        int n = map.length;
        int m = map[0].length();

        int[][] dist = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                dist[i][j] = -1;
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy));
        dist[sx][sy] = 0;
        

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == -1 && map[nx].charAt(ny) != 'x') {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }

        return dist;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            if (m == 0 && n == 0) {
                System.out.println(sb);
                System.exit(0);
            }

            String[] map = new String[n];
            for (int i=0; i<n; i++) {
                map[i] = sc.next();
            }

            ArrayList<Pair> store = new ArrayList<>();
            store.add(new Pair(0, 0));
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    char ch = map[i].charAt(j);

                    if (ch == 'o') {
                        store.set(0, new Pair(i, j));
                    } else if (ch == '*') {
                        store.add(new Pair(i, j));
                    }
                }
            }

            int len = store.size();
            boolean ok = true;
            int[][] d = new int[len][len];

            for (int i=0; i<len; i++) {
                Pair sp = store.get(i);
                int[][] dist = bfs(map, sp.x, sp.y);

                for (int j=0; j<len; j++) {
                    Pair ep = store.get(j);
                    d[i][j] = dist[ep.x][ep.y];

                    if (d[i][j] == -1) ok = false;
                }
            }

            if (!ok) {
                sb.append(-1).append("\n");
                continue;
            }

            int[] a = new int[len-1];
            for (int i=0; i<len-1; i++) {
                a[i] = i+1;
            }
            Arrays.sort(a);

            int ans = -1;
            do {
                int now = d[0][a[0]];

                for (int i=0; i<len-2; i++) {
                    now += d[a[i]][a[i+1]];
                }
                if (ans == -1 || ans > now) {
                    ans = now;
                }
            } while (next_permutation(a));
            sb.append(ans).append("\n");
        }

    }
}