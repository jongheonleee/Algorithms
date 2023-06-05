import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int alphabets = 'Z' - 'A' + 1;

    static boolean[] check = new boolean[alphabets];

    static char[][] board;

    static int getIndex(int x, int y) {
        char ch = board[x][y];
        int idx = ch - 'A';

        return idx;
    }

    static boolean isValidRange(int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }

    static int go(int x, int y, int step) {
        if (check[getIndex(x, y)] || !isValidRange(x, y)) {
            return step;
        }

        check[getIndex(x, y)] = true;
        step++;
        int max = step;

        for (int k=0; k<4; k++) {
            int nx = x+dx[k], ny = y+dy[k];

            if (!isValidRange(nx, ny)) continue;
            int tmp = go(nx, ny, step);

            if (max < tmp) {
                max = tmp;
            }
        }
        check[getIndex(x, y)] = false;
        return max;

    }

    public static void main(String[] args) throws IOException {
        // 기초 정보 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        int r = Integer.parseInt(line1[0]), c = Integer.parseInt(line1[1]);
        board = new char[r][c];

        for (int i=0; i<r; i++) {
            String line2 = br.readLine();
            for (int j=0; j<c; j++) {
                board[i][j] = line2.charAt(j);
            }

        }

        int ans = 1;
        ans = go(0, 0, 0);
        System.out.println(ans);


    }
}