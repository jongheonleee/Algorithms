import java.util.*;
import java.io.*;



// H : 0, T : 1
public class Main {

    private static int ans;

    private static int[][] board = new int[3][3];
    private static void go(int depth) {
        if (depth >= 8) return;

        if (check()) {
            if (ans == -1 || ans >= depth) ans = depth;
            return;
        }

        for (int d=0; d<8; d++) {
            flip(d);
            go(depth+1);
            flip(d);
        }
    }

    private static boolean check() {
        int sum = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                sum += board[i][j];
            }
        }

        return (sum == 0 || sum == 9);
    }

    private static void flip(int dir) {
        switch (dir) {
            case 0:
                // 1r
                for (int j=0; j<3; j++) {
                    board[0][j] = 1-board[0][j];
                }
                break;
            case 1:
                // 2r
                for (int j=0; j<3; j++) {
                    board[1][j] = 1-board[1][j];
                }
                break;
            case 2:
                // 3r
                for (int j=0; j<3; j++) {
                    board[2][j] = 1-board[2][j];
                }
                break;
            case 3:
                // 1c
                for (int i=0; i<3; i++) {
                    board[i][0] = 1-board[i][0];
                }
                break;
            case 4:
                // 2c
                for (int i=0; i<3; i++) {
                    board[i][1] = 1-board[i][1];
                }
                break;
            case 5:
                // 3c
                for (int i=0; i<3; i++) {
                    board[i][2] = 1-board[i][2];
                }
                break;
            case 6:
                // 1dia \
                for (int i=0; i<3; i++) {
                    board[i][i] = 1-board[i][i];
                }
                break;
            case 7:
                // 2dia /
                for (int i=0; i<3; i++) {
                    board[i][2-i] = 1-board[i][2-i];
                }
                break;
        }

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            for (int i=0; i<3; i++) {
                String[] line = br.readLine().split(" ");
                for (int j=0; j<3; j++) {
                    board[i][j] = line[j].equals("H") ? 0 : 1;
                }
            }

            ans = -1;
            go(0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

