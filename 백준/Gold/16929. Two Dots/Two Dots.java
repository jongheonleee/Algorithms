import java.util.*;
import java.io.*;

public class Main {

    static char[][] a;
    static boolean[][] check;
    static int[][] dist;
    static int n, m;

    final static int[] dx = {0, 0, 1, -1};
    final static int[] dy = {1, -1, 0, 0};

    static boolean go(int x, int y, int cnt, char color) {
        // 현재 방문한 칸이 이미 방문한 경우(사이클)
        if (check[x][y]) {
            // cnt : 시작점 -> 현재 점까지(x, y)의 거리 < 재방문 한 경우의 경로 길이
            // dist[x][y] : 이전에 방문했을 때의 거리 < 처음 방문했을 때의 경로 길이
            if (cnt - dist[x][y] >= 4) {
                return true;
            } else {
                return false;
            }
        }
        // 방문 체크
        check[x][y] = true;
        // 첫 방문했을 때, 시작점부터 현재점(x, y)까지의 거리
        dist[x][y] = cnt;
        
        for (int k=0; k<4; k++) {
            int nx = x+dx[k], ny = y+dy[k];
            // 다음 이동 지점 (nx, ny)가 박스 바운더리 내에 있는 경우
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                // 현재 칸의 색생과 다음 방문 칸의 색상이 같은 경우
                if (a[nx][ny] == color) {
                    // dfs 탐색 호출
                    if (go(nx, ny, cnt+1, color)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        a = new char[n][m];
        check = new boolean[n][m];
        
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                // 이미 방문한 경우 건너뛰기
                if (check[i][j]) continue;
                
                // 시작점 -> (x, y)까지의 거리 저장(첫 방문 기준)
                dist = new int[n][m];
                // dfs 탐색을 통해서 길이가 4 이상인 사이클이 존재하는지 판단함
                boolean ok = go(i, j, 1, a[i][j]);
                
                if (ok) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }
}