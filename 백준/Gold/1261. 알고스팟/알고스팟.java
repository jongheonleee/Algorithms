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
        int[][] d = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(d[i], -1);
        }


        d[0][0] = 0;
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(0, 0));
        
        while (!deque.isEmpty()) {
            Pair p = deque.poll();
            int x = p.x, y = p.y;
            
            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (d[nx][ny] == -1) {
                        if (a[nx][ny] == 0) {
                            d[nx][ny] = d[x][y];
                            deque.addFirst(new Pair(nx, ny));
                        }
                        else {
                            d[nx][ny] = d[x][y]+1;
                            deque.addLast(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println(d[n-1][m-1]);

    }
}