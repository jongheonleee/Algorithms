import java.util.*;
import java.io.*;
public class Main {

    static final int max = 1000*1000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][3], d = new int[n+1][3];

        for (int i=1; i<=n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<=2; j++) {
                cost[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = max+1;
        for (int fix=0; fix<=2; fix++) {
            for (int j=0; j<=2; j++) {
                // j번째 fix로 고정시키기
                if (j == fix) {
                    d[1][fix] = cost[1][fix];
                }
                // 고정되지 않은 경우는 최대값 저장해두기
                else {
                    d[1][j] = max + 1;
                }
            }

                // DP 알고리즘 적용하기
                for (int i=2; i<=n; i++) {
                    d[i][0] = cost[i][0] + Math.min(d[i-1][1], d[i-1][2]);
                    d[i][1] = cost[i][1] + Math.min(d[i-1][0], d[i-1][2]);
                    d[i][2] = cost[i][2] + Math.min(d[i-1][0], d[i-1][1]);
                }

                for (int j=0; j<=2; j++) {
                    // 마지막 번째 집이 첫번째 집의 색과 같은 경우 건너뜀
                    if (fix == j) continue;
                    // 최소값 갱신
                    if (result > d[n][j]) {
                        result = d[n][j];
                    }
                }
            }
        System.out.println(result);    
    }
}
