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

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]);

        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];
        boolean[][] check = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String line2 = br.readLine();
            for (int j=0; j<m; j++) {
                a[i][j] = line2.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
        dist[0][0] = 1;
        check[0][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            if (x == n-1 && y == m-1)
                break;

            for (int k=0; k<4; k++){
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1 && check[nx][ny] == false) {
                        q.add(new Pair(nx, ny));
                        check[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]);

    }
}