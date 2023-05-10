import java.util.*;
import java.io.*;


public class Main {

    private static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void dfs(int[][] a, boolean[][] check, int x, int y, int h, int w) {
        check[x][y] = true;

        for (int k=0; k<8; k++) {
            int nx = x+dx[k], ny = y+dy[k];

            if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                if (a[nx][ny] == 1 && check[nx][ny] == false) {
                    dfs(a, check, nx, ny, h, w);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] line1 = br.readLine().split(" ");
            int w = Integer.parseInt(line1[0]), h = Integer.parseInt(line1[1]);

            if (w == 0 && h == 0) break;

            int[][] a = new int[h][w];

            for (int i=0; i<h; i++) {
                String[] line2 = br.readLine().split(" ");
                for (int j=0; j<w; j++) {
                    a[i][j] = Integer.parseInt(line2[j]);
                }
            }
            boolean[][] check = new boolean[h][w];
            int cnt = 0;
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (a[i][j] == 1 && check[i][j] == false) {
                        cnt++;
                        dfs(a, check, i, j, h, w);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}