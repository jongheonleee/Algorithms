import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sbDfs = new StringBuilder(), sbBfs = new StringBuilder();
    static boolean[] check;
    static ArrayList<Integer>[] graph;

    public static void dfs(int v) {
        if (check[v]) return;

        check[v] = true;
        sbDfs.append(v).append(" ");

        for (int next : graph[v]) {
            if (!check[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        check[v] = true;

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            sbBfs.append(curr).append(" ");

            for (int next : graph[curr]) {
                if (!check[next]) {
                    check[next] = true;
                    queue.add(next);
                }
            }
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]), src = Integer.parseInt(line[2]);

        graph = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]), v = Integer.parseInt(line[1]);
            // 간선은 양방향
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i=1; i<=n; i++) {
            Collections.sort(graph[i]);
        }

        check = new boolean[n+1];
        dfs(src);
        check = new boolean[n+1];
        bfs(src);
        System.out.println(sbDfs);
        System.out.println(sbBfs);

    }
}