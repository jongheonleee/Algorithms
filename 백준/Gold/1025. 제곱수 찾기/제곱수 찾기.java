import java.util.*;
import java.io.*;


public class Main {

    private static int n, m, ans;
    private static int[][] table;

    private static boolean check(int number) {
        int k = (int)Math.sqrt(number);
        return k*k == number;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
            // 0-0. n, m입력 받기 및 ans -1로 초기화
            // 0-1. 표 구현
            // 0-2. 선택을 기록하는 판 구현
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        ans = -1;
        table = new int[n][m];

        for (int i=0; i<n; i++) {
            String line2 = br.readLine();
            for (int j=0; j<m; j++) {
                table[i][j] = line2.charAt(j)-'0';
            }
        }

        // 1. 칸 선택, 행/열 등차수열을 이루어야함
            // 1-0. (0, 0) ~ (n, m)중에서 하나 선정
            // 1-1. 행/열의 공차 선정
            // 1-2. 각각의 요소 선정하면서 숫자 생성
            // 1-3. 생성된 숫자가 완전 제곱수 인지 판단
            // 1-4. 결과와 비교하여 최대값 기록
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {

                for (int d1=-n; d1<n; d1++) {
                    for (int d2=-m; d2<m; d2++) {
                        if (d1 == 0 && d2 == 0) continue;
                        int number = 0;
                        int x = i, y = j;

                        while ((0 <= x && x < n && 0 <= y && y < m)) {
                            number = number * 10 + table[x][y];
                            if (check(number) && ans < number) ans = number; 
                            x += d1;
                            y += d2;
                        }

                        if (check(number) && ans < number) ans = number;
                    }
                }
            }
        }


        // 2. 결과 출력
            // 2-0. 결과가 없는 경우 -1, 그게 아니면 출력
        System.out.println(ans);
   }
}

