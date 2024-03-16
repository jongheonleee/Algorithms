import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/**
문제 요약
 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

 */

public class Main {

    /**
     접근법
        BFS
        1. 그래프 구현
        2. BFS 돌리기
        3. 방문 표시 카운트

     */



    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 0. 입력 받기
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        // 1. 그래프 구현
            // 연결
            // 방문 표시
        boolean[][] conn = new boolean[n+1][n+1];
        boolean[][] vis = new boolean[n+1][n+1];

        while (m-- > 0) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            conn[u][v] = conn[v][u] = true;
        }

        // 2. BFS 적용
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int u = q.remove();

            for (int v=1; v<=n; v++) {
                // 서로 같은 경우
                if (v == u) continue;
                // 연결이 안된 경우
                if (!conn[u][v] || !conn[v][u]) continue;
                // 이미 방문한 경우
                if (vis[u][v] || vis[v][u]) continue;

                q.add(v);
                vis[u][v] = true;
                set.add(v);
            }
        }

        // 3. 방문 표시 카운트 및 반환
        System.out.println(set.size());

    }
}

