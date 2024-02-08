import java.util.*;
import java.io.*;

/**
 * - N X M 행렬
 * - 원소의 값은 우주선이 그 공간을 지날 때 소모되는 연료의 양이다.
 * - 우주선 이동 방향 (x+1, y-1), (x+1, y), (x+1, y+1), 같은 방향 연속 x
 * - 달에 도달하기 위해 필요한 연료의 최소값
 */
public class Main {

    static int n, m, min;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int[][] map;

    // 행렬 범위내에 있는지 확인
    static boolean isInclude(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    // 특정 위치에서 달까지 도달하는 모든 경로 탐색(브루트포스)
        // i : 깊이, j : 이전 방향, (x, y) : 현재 위치, cost : 사용한 연료값
    static void go(int i, int j, int x, int y, int cost) {
        // 0. 종료조건
            // 0-0. 달에 도달한 경우 -> i = n
                // 0-0-0. 최소값 업데이트
        if (i == n) {
            if (min == -1 || min > cost) min = cost;
            return;
        }
        // 1. 탐색 진행
            // 1-0. 기존 방향과 다른 두 가지 방향 이동
            // 1-1. 죄표 범위가 포함되지 않은 경우
                // 1-1-1. 중단
        for (int k=0; k<3; k++) {
            if (k == j) continue;
            int nx = x+dx[k], ny = y+dy[k];
            if (isInclude(nx, ny)) go(i+1, k, nx, ny, cost+map[nx][ny]);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
            // 0-0. n, m, ans -> cv
            // 0-1. 행렬 -> cv
            // 0-2. 이동 방향 3가지 정의 -> cv
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        min = -1;

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 1. 이동 방향 탐색
            // 1-0. 시작점 선정 -> 0 행 m개 중에 한개 선정
            // 1-1. 그 위치를 기점으로 재귀 호출해가면서 달에 도달 -> 브루트 포스, 재귀구현
            // 1-2. 달에 도달했을 때 총 연료값 계산
            // 1-3. 최소값 업데이트
        for (int y=0; y<m; y++) {
            // -1은 방향 안정해졌다는 것을 의미,
            go(1, -1, 0, y, map[0][y]);
        }

        // 2. 최소값 출력
        System.out.println(min);

   }
}

