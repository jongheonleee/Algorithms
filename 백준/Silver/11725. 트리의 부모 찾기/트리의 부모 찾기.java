import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/**
문제 요약

 루트 없는 트리가 주어진다.
 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성

 */

public class Main {

    /**
     접근법
     그래프 구현(bfs)
     1부터 탐색
     u -> v, 이때 탐색했으면 v는 u의 부모

     */

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();

        // 0. 트리 구현
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i=0; i<n-1; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            
            tree[u].add(v);
            tree[v].add(u);
        }

        boolean[] vis = new boolean[n+1]; //  방문 표시 
        int[] parent = new int[n+1]; // 부모 표시
        
        // 1. BFS 적용 
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;
        
        while (!q.isEmpty()) {
            int u = q.remove();
            
            for (int v : tree[u]) {
                if (vis[v]) continue;
                
                vis[v] = true;
                parent[v] = u;
                q.add(v);
            }
        }
        // 2. 결과 출력
        for (int i=2; i<=n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);

    }
}
