import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {


    static final int MAX = 15;

    static int n;

    static boolean[][] board = new boolean[MAX][MAX];

    static boolean[] checkCol = new boolean[MAX];
    // / 대각선
    static boolean[] checkDig = new boolean[2*MAX];
    // \ 대각선
    static boolean[] checkDig2 = new boolean[2*MAX];


    static boolean check(int i, int j) {
        if (checkCol[j]) return false;
        if (checkDig[i+j]) return false;
        if (checkDig2[i-j+n]) return false;
        
        return true;
    }

    static int go(int row) {
        // 정답을 찾은 경우 row가 n까지 도달한 경우
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        for (int col=0; col<n; col++) {
            if (check(row, col)) {
                // 세팅
                checkCol[col] = true;
                checkDig[row+col] = true;
                checkDig2[row-col+n] = true;
                board[row][col] = true;

                cnt += go(row+1);

                checkCol[col] = false;
                checkDig[row+col] = false;
                checkDig2[row-col+n] = false;
                board[row][col] = true;

            }
        }
        
        return cnt;


    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int ans = go(0);
        System.out.println(ans);

    }
}