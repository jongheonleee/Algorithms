import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int i = Integer.parseInt(br.readLine());
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");

            int sx = Integer.parseInt(line1[0]), sy = Integer.parseInt(line1[1]);
            int ex = Integer.parseInt(line2[0]), ey = Integer.parseInt(line2[1]);
            
            int[][] cnt = new int[i][i];

            for (int j=0; j<i; j++) {
                Arrays.fill(cnt[j], -1);
            }

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(sx, sy));
            cnt[sx][sy] = 0;

            while (!q.isEmpty()) {
                Pair p = q.remove();
                int x = p.x, y = p.y;

                if (x == ex && y == ey) {
                    sb.append(cnt[ex][ey]).append("\n");
                    break;
                }

                for (int k=0; k<8; k++) {
                    int nx = x+dx[k], ny = y+dy[k];

                    if (0 <= nx && nx < i && 0 <= ny && ny < i) {
                        if (cnt[nx][ny] == -1) {
                            cnt[nx][ny] = cnt[x][y]+1;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}