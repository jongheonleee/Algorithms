import java.io.*;
import java.util.*;
public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static final int n = 9;
    private static int square(int x, int y) {
        // 3*3 정사각형이 스도쿠에 총 9개가 있음
        // 이를 1차원 배열로 바꿔주기 위해서
        // 행과 열을 /3을 해줘서 축소한 다음 3개의 행을 *3으로 다시 표현함
        // 즉 0은 맨 첫번째 정사각형을 의미하고 9는 마지막 정사각형을 의미함
        return (x/3)*3 + (y/3);
    }

    private static boolean go(int[][] a, boolean[][][] c, int z) {
        // 정답을 찾은 경우, 호출 중단
        if (z == n*n) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    sb.append(a[i][j]).append(" ");
                }
                sb.append("\n");
            }

            return true;
        }

        int x = z/n; int y = z%n;

        // 해당 칸 (z)가 이미 채워진 경우
        if (a[x][y] != 0) {
            // 다음 칸으롷 이동
            return go(a, c, z+1);
        }
        else {
            for (int i=1; i<=9; i++) {
                if (!c[0][x][i] && !c[1][y][i] && !c[2][square(x, y)][i]) {
                    c[0][x][i] = c[1][y][i] = c[2][square(x, y)][i] = true;
                    a[x][y] = i;

                    if (go(a, c, z+1)) {
                        return true;
                    }
                    a[x][y] = 0;
                    c[0][x][i] = c[1][y][i] = c[2][square(x, y)][i] = false;
                }
            }
        }
        return false;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] a = new int[n][n];
        // 이 부분이 핵심임
        // 0 : 행에 해당 숫자의 존재 여부를 저장함
        // 1 : 열에 해당 숫자의 존재 여부를 저장함
        // 2 : 3*3 정사각형에 해당 숫자의 존재 여부를 저장함
        boolean[][][] c = new boolean[3][n][10];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                a[i][j] = line[j].charAt(0) - '0';

                if (a[i][j] != 0) {
                    // i번째 행에 a[i][j] 숫자가 있음
                    c[0][i][a[i][j]] = true;
                    // j번째 열에 a[i][j] 숫자가 있음
                    c[1][j][a[i][j]] = true;
                    // i번째 행에 a[i][j] 숫자가 있음
                    c[2][square(i, j)][a[i][j]] = true;
                }
            }
        }
        go(a, c, 0);
        System.out.println(sb);
    }
}