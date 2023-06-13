import java.io.*;
import java.util.*;

class Point {
    int x, y, t;

    Point(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}


public class Main {
    static final int N = 8;

    static String[] map = new String[N];
    static boolean[][][] check = new boolean[N][N][N+1];

    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1, 0};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1, 0};


    static boolean can(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<N; i++) {
            map[i] = br.readLine();
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N-1, 0, 0));
        check[N-1][0][0] = true;

        while (!(q.isEmpty())) {
            Point p = q.remove();

            int x = p.x;
            int y = p.y;
            int t = p.t;

            for (int k=0; k<9; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                int nt = Math.min(t+1, 8);

                if (can(nx, ny) == false) continue;
                if (check[nx][ny][nt] == true) continue;
                // 스킵해야하는 경우가 두 가지가 있음
                // 1. 다음으로 이동하려는 칸에 벽이 있는 경우
                if (nx - t >= 0 && map[nx-t].charAt(ny) == '#') continue;

                // 2. 다음으로 이동은 했지만 그 뒤에 바로 벽이 오는 경우
                if (nx - (t+1) >= 0 && map[nx-(t+1)].charAt(ny) == '#') continue;


                check[nx][ny][nt] = true;
                q.add(new Point(nx, ny, nt));
            }
        }

        int ans = 0;
        for (int t=0; t<=8; t++) {
            if (check[0][N-1][t]) ans = 1;
        }
        System.out.println(ans);
    }

}