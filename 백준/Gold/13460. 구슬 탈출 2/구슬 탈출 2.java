import java.util.*;
import java.io.*;
class Result {
    boolean moved, hole;
    int x, y;

    Result(boolean moved, boolean hole, int x, int y) {
        this.moved = moved;
        this.hole = hole;
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static final int LIMIT = 10;

    static int[] gen(int k) {
        int[] dir = new int[LIMIT];

        for (int i=0; i<LIMIT; i++) {
            dir[i] = (k&3);
            k >>= 2;
        }

        return dir;
    }

    static boolean isValid(int[] dir) {
        for (int i=0; i<dir.length-1; i++) {
            if (dir[i] == dir[i+1]) return false;

            if (dir[i] == 0 && dir[i+1] == 1) return false;
            if (dir[i] == 1 && dir[i+1] == 0) return false;
            if (dir[i] == 2 && dir[i+1] == 3) return false;
            if (dir[i] == 3 && dir[i+1] == 2) return false;
        }

        return true;
    }

    static int check(char[][] board, int[] dir) {
        int row = board.length, col = board[0].length;
        
        int hx = 0, hy = 0;
        int rx = 0, ry = 0;
        int bx = 0, by = 0;
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                } else if (board[i][j] == 'O') {
                    hx = i; hy = j;
                }
            }
        }

        int step = 0;
        for (int k : dir) {
            step++;
            boolean hole1 = false, hole2 = false;

            while (true) {
                Result p1 = simulate(board, k, rx, ry);
                rx = p1.x; ry = p1.y;

                Result p2 = simulate(board, k, bx, by);
                bx = p2.x; by = p2.y;

                if (p1.moved == false && p2.moved == false) break;

                if (p1.hole) hole1 = true;
                if (p2.hole) hole2 = true;

            }

            if (hole2) return -1;
            if (hole1) return step;
        }

        return -1;

    }

    static Result simulate(char[][] board, int k, int x, int y) {
        int row = board.length, col = board[0].length;
        boolean moved = false;

        if (board[x][y] == '.') {
            return new Result(moved, false, x, y);
        }

        while (true) {
            int nx = x+dx[k], ny = y+dy[k];

            if (!(0 <= nx && nx < row && 0 <= ny && ny < col)) {
                return new Result(moved, false, x, y);
            }

            char what = board[nx][ny];

            if (what == '#') {
                return new Result(moved, false, x, y);

            } else if (what == 'R' || what == 'B') {
                return new Result(moved, false, x, y);

            } else if (what == '.') {
                char tmp = board[nx][ny];
                board[nx][ny] = board[x][y];
                board[x][y] = tmp;

                x = nx; y = ny;
                moved = true;

            } else if (what == 'O') {
                board[x][y] = '.';
                moved = true;

                return new Result(moved, true, x, y);
            }
        }
    }



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 보드판 구현하기
        String[] line = br.readLine().split(" ");
        int row = Integer.parseInt(line[0]), col = Integer.parseInt(line[1]);

        char[][] board = new char[row][col];
        String[] map = new String[row];

        for (int i=0; i<row; i++) {
            map[i] = br.readLine();
        }

        int ans = -1;
        for (int k=0; k<(1<<(LIMIT*2)); k++) {
            int[] dir = gen(k);
            if (isValid(dir) == false) continue;

            for (int i=0; i<row; i++) {
                board[i] = map[i].toCharArray();
            }

            int step = check(board, dir);
            if (step == -1) continue;
            if (ans == -1 || ans > step) ans = step;
        }
        System.out.println(ans);

    }
}