import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] check;

    static void dfs(int v) {
        if (check[v]) return;

        check[v] = true;
        for (int next : graph[v]) {
            dfs(next);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);

        graph = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<=m-1; i++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]), v = Integer.parseInt(line[1]);
            // 방향없는 그래프
            graph[u].add(v);
            graph[v].add(u);
        }

        check = new boolean[n+1];

        int result = 0;
        for (int src=1; src<=n; src++) {
            if (check[src]) continue;
            dfs(src);
            result++;
        }

        System.out.println(result);
    }
}