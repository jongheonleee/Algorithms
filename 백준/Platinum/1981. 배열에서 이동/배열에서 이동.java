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
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] a = new int[100][100];
    static boolean[][] visited = new boolean[100][100];


    static boolean check(int diff) {
        for (int min = 0; min+diff <= 200; min++) {
            if (bfs(min, min+diff)) return true;
        }

        return false;
    }

    static boolean bfs(int min, int max) {
        for (int i=0; i<n; i++) {
           for (int j=0; j<n; j++) {
               visited[i][j] = false;
           }
        }
        Queue<Pair> q = new LinkedList<>();

        // src
        if (!(min <= a[0][0] && a[0][0] <= max)) return false;
        q.add(new Pair(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];


                if (!(0 <= nx && nx < n && 0 <= ny && ny < n)) continue;
                if (visited[nx][ny]) continue;
                if (!(min <= a[nx][ny] && a[nx][ny] <= max)) continue;

                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;

            }

        }

        return visited[n-1][n-1];

    }


    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int left = 0, right = 200, ans = 200;
        while (left <= right) {
            int mid = (left+right)/2;

            if (check(mid)) {
                ans = Math.min(ans, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(ans);

    }
}