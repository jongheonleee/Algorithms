import java.util.*;
import java.io.*;

class Edge {
    int to;
    int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    static int[] bfs(int n, List<Edge>[] a, int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n+1];
        boolean[] check = new boolean[n+1];
        q.add(start); dist[start] = 0; check[start] = true;

        while (!q.isEmpty()) {
            int x = q.remove();
            for (Edge e : a[x]) {
                int y = e.to;
                int cost = e.cost;

                if (check[y] == false) {
                    dist[y] = dist[x] + cost;
                    check[y] = true;
                    q.add(y);
                }
            }
        }

        return dist;
    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge>[] a = (List<Edge>[])new List[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Edge>();
        }

        // 트리 구현해주기
        for (int i=1; i<=n; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) break;
                int z = sc.nextInt();

                a[x].add(new Edge(y, z));
            }
        }

        // bfs 탐색 2번 진행해주기
        int[] dist = bfs(n, a, 1);
        int start = 1;
        for (int i=2; i<=n; i++) {
            if (dist[start] < dist[i]) {
                start = i;
            }
        }

        dist = bfs(n, a, start);

        // 최대 길이(지름) 찾기
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (dist[i] > ans) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }
}