import java.util.*;
import java.io.*;

/**
 *  정점 n, 간선 m인 양방향 가중치 그래프
 *  n개 중 2개 선택, 그때의 가장 가까운 치킨집까지 왕복하는 최단 거리
 *  - 플로이드 : O(v^3), 브루트 포스 : O(v^2) -> O(v^3)
 */
public class Main {

    static int n, m, a, b, min;
    static final int MAX = 100_000;
    static int[][] dist;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
            // 0-0. n, m 입력 받기 min, a, b -> cv
            // 0-1. 가중치 그래프, 2차원 배열로 기록 -> cv
            // 0-2. 플로이드 워셜 초기화
                // 0-2-0. 같은 위치는 0, i -> j 1, 그 외의 무한대값(MAX)
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        a = -1;
        b = -1;
        min = MAX;

        dist = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dist[i][j] = i == j ? 0 : MAX;
            }
        }

        for (int k=0; k<m; k++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            dist[u-1][v-1] = 1;
            dist[v-1][u-1] = 1;
        }

        // 1. 모든 정점에 대해 최단 거리 구하기 -> 플로이드
            // 1-0. 중간 경유지 k 선정, i, j 선정
            // 1-1. 계속해서 업데이트
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 2. 치킨 집 2개 선정 -> 브루트 포스
            // 2-0. n개 중에 2개 선정
            // 2-1. 그때의 "모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합" 계산
            // 2-2. 최소값 업데이트
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int sum = 0;

                for (int k=0; k<n; k++) {
                    if (k == i || k == j) continue;
                    sum += Math.min(dist[i][k] + dist[k][i], dist[j][k] + dist[k][j]);
                }

                if (min > sum) {
                    min = sum;
                    a = i+1;
                    b = j+1;
                }
            }

        }

        // 3. 결과 출력
        System.out.println(a + " " + b + " " + min);
   }
}
