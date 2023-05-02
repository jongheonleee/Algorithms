import java.util.*;
import java.io.*;
public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineArr = br.readLine().split(" ");
        int n = Integer.parseInt(lineArr[0]), m = Integer.parseInt(lineArr[1]);
        int[][] a = new int[n][m];

        for (int i=0; i<n; i++) {
            String lineStr = br.readLine();
            for (int j=0; j<m; j++) {
                a[i][j] = lineStr.charAt(j) - '0';
            }
        }

        int result = 0;
        // 전체 집합 2^(n*m) -1, 선택의 관점에서 가로 박스를 선택한 경우 0, 세로 박스를 선택한 경우 1
        // 문제에서 주어진 박스를 1차원 배열로 가정한 뒤, 선택의 관점에서 1, 0으로 만들 수 있는 모든 조합 만들기
        for (int s=0; s<(1<<(n*m)); s++) {
            // 누적합 계산
            int sum = 0;
            // 가로 박스의 숫자를 각 각 구해서 더하는 경우
            // 행을 기준으로 접근하기
            for (int i=0; i<n; i++) {
                // 각 행에 있는 가로 박스의 숫자 구해주기
                int curr = 0;
                // 행 탐색하기 0~m
                for (int j=0; j<m; j++) {
                    // 1차원 배열로 가정했을 때, (i, j)의 위치는 k
                    int k = i*m+j;
                    // 해당 위치의 값이 0인 경우, 즉 가로 박스인 경우
                    if ((s & 1<<k) == 0) {
                        // 숫자 세주기
                        curr = curr*10 + a[i][j];
                    }
                    // 가로 박스가 끝난 경우
                    else {
                        // 더해주기
                        sum += curr;
                        // 초기화
                        curr = 0;
                    }
                }
                sum += curr;
            }
            // 세로 박스의 숫자를 각 각 구해서 더하는 경우
            // 열을 기준으로 접근하기
            for (int j=0; j<m; j++) {
                int curr = 0;
                for (int i=0; i<n; i++) {
                    int k = i*m+j;
                    if ((s & 1 << k) != 0) {
                        curr = curr * 10 + a[i][j];
                    }
                    else {
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}