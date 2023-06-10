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

    static int[][] board;
    static int[][] copyBoard;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int bfs() {
        int size = 0;
        Queue<Pair> q = new LinkedList<>();

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                copyBoard[i][j] = board[i][j];

                if (board[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        while (!(q.isEmpty())) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if(0 <= nx && nx <board.length && 0 <= ny && ny < board[0].length) {
                    if (copyBoard[nx][ny] == 0) {
                        copyBoard[nx][ny] = 2;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        for (int i=0; i<copyBoard.length; i++) {
            for (int j=0; j<copyBoard[0].length; j++) {
                if (copyBoard[i][j] == 0) size++;
            }
        }

        return size;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);

        board = new int[n][m];
        copyBoard = new int[n][m];

        // 보드판 구현하기
        for (int i=0; i<n; i++) {
            line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = 0;

        // 벽을 놓을 수 있는 모든 경우의 수 구하기
        for (int i1=0; i1<n; i1++) {
            for (int j1=0; j1<m; j1++) {
                if (board[i1][j1] != 0) continue;

                for (int i2=0; i2<n; i2++) {
                    for (int j2=0; j2<m; j2++) {
                        if (board[i2][j2] != 0) continue;

                        for (int i3=0; i3<n; i3++) {
                            for (int j3=0; j3<m; j3++) {
                                if (board[i3][j3] != 0) continue;

                                // 중복되는 경우 건너뛰기
                                if (i1 == i2 && j1 == j2) continue;
                                if (i1 == i3 && j1 == j3) continue;
                                if (i2 == i3 && j2 == j3) continue;

                                // 벽 세우기
                                board[i1][j1] = board[i2][j2] = board[i3][j3] = 1;

                                // bfs 알고리즘 적용
                                int size = bfs();
                                if (ans < size) {
                                    ans = size;
                                }

                                // 초기화
                                board[i1][j1] = board[i2][j2] = board[i3][j3] = 0;

                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);


    }
}