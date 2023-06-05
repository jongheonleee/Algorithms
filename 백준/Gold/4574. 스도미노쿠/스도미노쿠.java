import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static final String msg = "Puzzle ";

    static final int n = 9;

    static int testCase = 1;
    static int[][] board = new int[n+1][n+1];

    static boolean[][][] check = new boolean[3][n+1][n+1];

    static boolean[][] domino = new boolean[n+1][n+1];


    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static int square(int x, int y) {
        return (x/3) * 3 + (y/3);
    }

    static boolean checkRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    static boolean can(int x, int y, int num) {
        if (check[0][x][num]) return false;
        if (check[1][y][num]) return false;
        if (check[2][square(x, y)][num]) return false;

        return true;
    }

    static void init() {
        for (int i=0; i<=n; i++) {
            Arrays.fill(board[i], 0);
            Arrays.fill(check[0][i], false);
            Arrays.fill(check[1][i], false);
            Arrays.fill(check[2][i], false);
            Arrays.fill(domino[i], false);
        }
    }

    static boolean go(int step) {
        // 정답을 찾은 경우 출력해주기
        if (step == n*n) {
            printBoard();
            return true;
        }

        int x = step/n, y = step%n;

        // 이미 채워진 경우 건너뜀
        if (board[x][y] != 0) {
            return go(step+1);
        }
        else {
            for (int k=0; k<2; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (!checkRange(nx, ny)) continue;
                if (board[nx][ny] != 0) continue;

                for (int n1=1; n1<=9; n1++) {
                    for (int n2=1; n2<=9; n2++) {
                        if (domino[n1][n2] || n1 == n2) continue;

                        if (can(x, y, n1) && can(nx, ny, n2)) {
                            board[x][y] = n1; board[nx][ny] = n2;
                            checkWhat(x, y, n1, true); checkWhat(nx, ny, n2, true);
                            domino[n1][n2] = domino[n2][n1] = true;

                            if (go(step+1)) {
                                return true;
                            }

                            board[x][y] = 0; board[nx][ny] = 0;
                            checkWhat(x, y, n1, false); checkWhat(nx, ny, n2, false);
                            domino[n1][n2] = domino[n2][n1] = false;

                        }
                    }
                }

            }
        }

        return false;
    }


    static void checkWhat(int x, int y, int num, boolean what) {
        check[0][x][num] = what;
        check[1][y][num] = what;
        check[2][square(x, y)][num] = what;
    }

    static void printBoard() {
        System.out.println(msg + testCase);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        testCase++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int m = Integer.parseInt(br.readLine());

            if (m == 0) break;

            // 초기화
            init();

            // 초기값 세팅
            for (int i=0; i<m; i++) {
                String[] input1 = br.readLine().split(" ");
                int n1 = Integer.parseInt(input1[0]); String s1 = input1[1];
                int n2 = Integer.parseInt(input1[2]); String s2 = input1[3];

                int x1 = s1.charAt(0) - 'A', y1 = s1.charAt(1) - '1';
                int x2 = s2.charAt(0) - 'A', y2 = s2.charAt(1) - '1';

                board[x1][y1] = n1; board[x2][y2] = n2;
                checkWhat(x1, y1, n1, true);
                checkWhat(x2, y2, n2, true);
                domino[n1][n2] = domino[n2][n1] = true;
            }

            String[] input2 = br.readLine().split(" ");
            for (int i=1; i<=n; i++) {
                int x = input2[i-1].charAt(0) - 'A';
                int y = input2[i-1].charAt(1) - '1';

                board[x][y] = i;
                checkWhat(x, y, i, true);
            }

            go(0);

        }
    }
}