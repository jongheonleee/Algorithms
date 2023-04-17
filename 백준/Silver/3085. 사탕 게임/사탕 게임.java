import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static char[][] board;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int ans = 1;
        // 2차원 배열(char)을 기준으로 board 사탕판 구현해주기
        board = new char[n][n];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // 이중 for 문으로 모든 사탕 선택해주기. 브루트 포스 알고리즘 적용하기
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // 스왑을 할 때 인덱스 부분 고려하기
                int len = 1;
                // 예외처리
                if (i == n-1 && j == n-1) continue;

                // 옆으로 아래로 스왑 가능한 경우
                if ((0 <= i && i <= n-2) && (0 <= j && j <= n-2)) {
                    // 아래로 스왑한 경우
                    swap(i, j, i+1, j);
                    len = calLen();
                    if (ans < len) ans = len;
                    // 다시 되돌리기
                    swap(i, j, i+1, j);

                    // 옆으로 스왑한 경우
                    swap(i, j, i, j+1);
                    len = calLen();
                    if (ans < len) ans = len;
                    // 다시 되돌리기
                    swap(i, j, i, j+1);
                }
                // 맨 아래 행의 경우 옆으로만 스왑이 가능함
                else if (i == n-1) {
                    // 옆으로 스왑만 가능한 경우
                    swap(i, j, i, j+1);
                    len = calLen();
                    if (ans < len) ans = len;
                    // 다시 되돌리기
                    swap(i, j, i, j+1);
                }
                // 맨 오른족 열의 경우 아래로만 스왑이 가능함
                else {
                    swap(i, j, i+1, j);
                    len = calLen();
                    if (ans < len) ans = len;
                    swap(i, j, i+1, j);

                }

            }
        }

        System.out.println(ans);

    }

    public static void swap (int i1, int j1, int i2, int j2) {
        char tmp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = tmp;

    }

    public static int calLen() {
        int max = 1;
        for (int i=0; i<n; i++) {
            int len = 1;
            for (int j=0; j<n-1; j++) {
                if (board[i][j] == board[i][j+1]) {
                    len++;
                }
                else {
                    if (max < len) max = len;
                    len = 1;
                }
            }

            if (max < len) max = len;
        }

        for (int j=0; j<n; j++) {
            int len = 1;
            for (int i=0; i<n-1; i++) {
                if (board[i][j] == board[i+1][j]) {
                    len++;
                }
                else {
                    if (max < len) max = len;
                    len = 1;
                }
            }

            if (max < len) max = len;
        }
        return max;
    }
}