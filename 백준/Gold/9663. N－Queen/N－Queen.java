import java.util.*;
public class Main {

    static int max = 15;
    static boolean[][] a = new boolean[max][max];
    static int n;
    // i번 열에 퀸이 놓여져 있으면 true
    static boolean[] check_col = new boolean[max];
    // 대각선을 나타낸 배열은 1차원 배열로 나타냈으며 / = row + col, \ = row-col+n임
    // / 방향에 퀸이 있으면 true
    static boolean[] check_dig = new boolean[max+max];
    // \ 방향에 퀸이 있으면 true
    static boolean[] check_dig2 = new boolean[max+max];
    // 점 (row, col)을 기준으로 가로나 세로나 대각선에 퀸이 있는지 검사하기
    static boolean check(int row, int col) {
        // 퀸이 있으면 false 반환
        if (check_col[col]) {
            return false;
        }
        // /(오른쪽 위 대각선)
        if (check_dig[row+col]) {
            return false;
        }
        // \(왼쪽 위 대각선)
        if (check_dig2[row-col+n]) {
            return false;
        }
        return true;
    }
    // row 행에 퀸을 어디에 놓을지 결정해야 하는 함수
    static int calc(int row) {
        // 정답을 찾은 경우 : 모든 n개의 행에 퀸을 놓은 경우
        if (row == n) {
            // ans += 1;
            return 1;
        }
        int cnt = 0;
        // 해당 행에 퀸이 어디에 있어야 하는지 모름
        // 0~n까지 한번 다 해보기
        // 임의의 위치에 퀸이 놓여졌을 때, 가로나 세로나 대각선에 퀸이 있는지 검사하기
        for (int col=0; col<n; col++) {
            if (check(row, col)) {
                // 세팅
                check_dig[row+col] = true;
                check_dig2[row-col+n] = true;
                check_col[col] = true;
                a[row][col] = true;
                // 호출 다음 행으로 이동
                cnt += calc(row+1);
                // 초기화
                check_dig[row+col] = false;
                check_dig2[row-col+n] = false;
                check_col[col] = false;
                a[row][col] = false;
            }
        }
        return cnt;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(calc(0));
    }
}