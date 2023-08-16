import java.util.*;
import java.io.*;



public class Main {

    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] board;

    static int bfs() {
        boolean[][] check = new boolean[n][m];
        int ans = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 2 && check[i][j] == false) {
                    int cnt = 0;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i); q.add(j);
                    check[i][j] = true;
                    boolean ok = true;

                    while (!q.isEmpty()) {
                        int x = q.remove();
                        int y = q.remove();
                        
                        cnt += 1;

                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if (board[nx][ny] == 0) {
                                    ok = false;
                                } else if (board[nx][ny] == 2 && check[nx][ny] == false) {
                                    q.add(nx);
                                    q.add(ny);
                                    check[nx][ny] = true;
                                }
                            }
                        }
                    }

                    if (ok) {
                        ans += cnt;
                    }
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = 0;
        for (int x1=0; x1<n; x1++) {
            for (int y1=0; y1<m; y1++) {
                if (board[x1][y1] != 0) continue;
                for (int x2=0; x2<n; x2++) {
                    for (int y2=0; y2<m; y2++) {
                        if (x1 == x2 && y1 == y2) continue;
                        if (board[x2][y2] != 0) continue;

                        board[x1][y1] = 1;
                        board[x2][y2] = 1;

                        int res = bfs();
                        if (ans < res) ans = res;

                        board[x1][y1] = 0;
                        board[x2][y2] = 0;
                    }
                }
            }
        }
        System.out.println(ans);




    }
}