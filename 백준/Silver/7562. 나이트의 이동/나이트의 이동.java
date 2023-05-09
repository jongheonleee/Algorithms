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

    public static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int sx = sc.nextInt(), sy = sc.nextInt();
            int ex = sc.nextInt(), ey = sc.nextInt();

            int[][] b = new int[n][n];

            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++) {
                    b[i][j] = -1;
                }
            }

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(sx, sy));
            b[sx][sy] = 0;

            while (!q.isEmpty()) {
                Pair p = q.remove();
                int x = p.x, y = p.y;

                if (x == ex && y == ey){
                    sb.append(b[ex][ey]).append("\n");
                    break;
                }

                for (int k=0; k<8; k++) {
                    int nx = x+dx[k], ny = y+dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (b[nx][ny] == -1){
                            q.add(new Pair(nx, ny));
                            b[nx][ny] = b[x][y] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(sb);

    }
}