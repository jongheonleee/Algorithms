import java.util.*;
import java.io.*;

/**
 * n(2 ≤ n ≤ 100)개의 도시, 1 ≤ m ≤ 100,000)개의 버스
 * 모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값
 */
public class Main {

    static int max = 1_000_000_000;
    static int n, m;
    static int[][] dist;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0. 세팅
            // 0-0. n,m 받기
            // 0-1. 그래프 구현
                // 0-1-0. 간선 정보 2차원 배열
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dist[i][j] = i == j ? 0 : max;
            }
        }

        for (int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            dist[a-1][b-1] = dist[a-1][b-1] > w ? w : dist[a-1][b-1];
        }

        // 1. 모든쌍에 대해 최단 경로 기록
            // * 플로이드 워샬
            // 1-0. shortestPath(i, j, k) : 'i -> j' or 'i -> k -> j' 중 최소값 기록
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    dist[i][j] = dist[i][j] > dist[i][k] + dist[k][j] ?
                            dist[i][k] + dist[k][j] : dist[i][j];
                }
            }
        }

        // 2. 출력
            // 2-0. 그래프 간선 정보 출력
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // 도달 할 수 있는 곳
                if (dist[i][j] != max) {
                    bw.write(dist[i][j] + " ");
                } 
                // 도달 할 수 없는 곳
                else {
                    bw.write(0 + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
   }
}