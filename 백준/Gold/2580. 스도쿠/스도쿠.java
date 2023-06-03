import java.io.*;
import java.util.*;
public class Main {

    static final int n = 9;
    static StringBuilder sb = new StringBuilder();
    static boolean[][][] check = new boolean[3][n][n+1];

    static int[][] a = new int[n][n];

    static int square(int x, int y) {
        return (x/3) * 3 + (y/3);
    }

    static boolean go(int i) {
        // 정답을 찾은 경우, 모든 칸을 다 채웠을 때
        if (i == n*n) {
            for (int x=0; x<n; x++) {
                for (int y=0; y<n; y++) {
                    sb.append(a[x][y]).append(" ");
                }
                sb.append("\n");
            }
            return true;
        }

        // 다음을 호출하는 경우
        int x = i/n; int y = i%n;

        // 이미 채워진 경우 스킵하고 바로 다음 경우 호출
        if (a[x][y] != 0) {
            return go(i+1);
        }
        else {
            // 채워지지 않은 경우
            for (int num=1; num<=9; num++) {
                // 해당 숫자를 사용해도 되는지 확인하기
                // 행/열/정사각형에서 해당 숫자가 나왔는지 안나왔는지 확인해보기
                if (check[0][x][num] == false
                        && check[1][y][num] == false
                        && check[2][square(x, y)][num] == false) {
                    // 안나온 경우
                    // 세팅
                    a[x][y] = num;
                    check[0][x][num] = true;
                    check[1][y][num] = true;
                    check[2][square(x, y)][num] = true;

                    // 다음 경우 호출
                    if (go(i + 1)) {
                        return true;
                    }
                    ;

                    // 초기화
                    a[x][y] = 0;
                    check[0][x][num] = false;
                    check[1][y][num] = false;
                    check[2][square(x, y)][num] = false;

                }
            }
        }

        return false;

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 보드판 세팅해주기
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                int num = line[j].charAt(0) - '0';
                a[i][j] = num;

                if (num != 0) {
                    // 세팅해주기(행, 열, 정사각형)
                    check[0][i][num] = true;
                    check[1][j][num] = true;
                    check[2][square(i, j)][num] = true;
                }
            }
        }

        if (go(0)) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        };
    }
}