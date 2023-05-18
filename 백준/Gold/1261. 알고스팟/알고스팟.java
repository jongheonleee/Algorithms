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

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int m = Integer.parseInt(line1[0]), n = Integer.parseInt(line1[1]);
        int[][] a = new int[n][m];

        for (int i=0; i<n; i++) {
            String line2 = br.readLine();

            for (int j=0; j<m; j++) {
                a[i][j] = line2.charAt(j)-'0';
            }
        }
        int[][] dist = new int[n][m];
        ArrayDeque<Pair> deq = new ArrayDeque<>();
        deq.add(new Pair(0, 0));

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                dist[i][j] = -1;
            }
        }

        dist[0][0] = 0;
        while(!deq.isEmpty()) {
            Pair p = deq.poll();
            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == -1) {
                        if (a[nx][ny] == 0) {
                            dist[nx][ny] = dist[x][y];
                            deq.addFirst(new Pair(nx, ny));
                        }
                        else {
                            dist[nx][ny] = dist[x][y] + 1;
                            deq.addLast(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}