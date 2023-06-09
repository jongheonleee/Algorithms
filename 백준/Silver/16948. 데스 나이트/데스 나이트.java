import javax.swing.*;
import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n;

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static boolean can(int x, int y) {
        return (0 <= x && x < n && 0<= y && y < n);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[][] dist = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dist[i][j] = -1;
            }
        }

        int r1 = Integer.parseInt(line[0]);
        int c1 = Integer.parseInt(line[1]);
        int r2 = Integer.parseInt(line[2]);
        int c2 = Integer.parseInt(line[3]);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r1, c1));
        dist[r1][c1] = 0;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            if (x == r2 && y == c2) break;


            for (int k=0; k<6; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (can(nx, ny) == false) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        System.out.println(dist[r2][c2]);
    }
}