import java.util.*;
import java.io.*;
public class Main {

    public static boolean dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                if (dfs(a, color, y, 3-c) == false) {
                    return false;
                }
            } else if (color[y] == color[x]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
            // 인접 리스트로 그래프 구현
            ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n+1];

            for (int i=1; i<=n; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            // 양방향 그래프 구현
            for (int i=0; i<m; i++) {
                String[] line2 = br.readLine().split(" ");
                int u = Integer.parseInt(line2[0]), v = Integer.parseInt(line2[1]);
                graph[u].add(v);
                graph[v].add(u);
            }

            // 그룹 분류해주는 배열, check 와 같은 역할로 0 = 방문안함, 1 : 그룹 1, 2 : 그룹2
            int[] color = new int[n+1];
            // 모든 간선에 대해 색이 같은게 있으면 이분 그래프가 아님
            boolean ok = true;

            for (int i=1; i<=n; i++) {
                if (color[i] == 0) {
                    if (dfs(graph, color, i, 1) == false) {
                        ok = false;
                    }
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}