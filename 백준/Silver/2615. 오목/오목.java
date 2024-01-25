import java.util.*;
import java.io.*;

public class Main {
    private static final int LENGTH = 19;

    private static int[] dx = {1, 0, 1, -1};
    private static int[] dy = {0, 1, 1, 1};
    private static int[][] board;
    private static int winner, ansX, ansY;

    private static void search(int x, int y, int num) {
        for (int k=0; k<4; k++) {
            int dirX = dx[k], dirY = dy[k], depth = 1;
            int nx = x, ny = y;
            for (int i=0; i<4; i++) {
                nx += dirX;
                ny += dirY;
                if (!check(nx, ny, num)) break;
                depth++;
            }
            if (depth == 5) {
                if (isInclude(x-dirX, y-dirY) && board[x-dirX][y-dirY] == num) continue;
                if (isInclude(x+5*dirX, y+5*dirY) && board[x+5*dirX][y+5*dirY] == num) continue;
                if (winner != 0) continue;

                winner = num;
                ansX = x+1;
                ansY = y+1;
            }
        }
    }

    private static boolean check(int x, int y, int num) {
        return !(isInclude(x, y) == false|| board[x][y] != num);
    }

    private static boolean isInclude(int x, int y) {
        return ((0 <= x && x < LENGTH) && (0 <= y && y < LENGTH));
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[LENGTH][LENGTH];
        for (int i=0; i<LENGTH; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<LENGTH; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        winner = 0;
        for (int x=0; x<LENGTH; x++) {
            for (int y=0; y<LENGTH; y++) {
                if (board[x][y] != 0) {
                    search(x, y, board[x][y]);
                }
            }
        }

        if (winner == 0) {
            System.out.println(winner);
        } else {
            System.out.println(winner);
            System.out.println(ansX + " " + ansY);
        }
    }
}


