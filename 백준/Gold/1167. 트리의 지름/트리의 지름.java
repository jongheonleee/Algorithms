import java.lang.reflect.Array;
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
        int[] dist = new int[n+1];
        boolean[] check = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(start); check[start] = true;

        while (!q.isEmpty()) {
            int x = q.remove();

            for (Edge e : a[x]) {
                int y = e.to;
                int z = e.cost;

                if (check[y] == false) {
                    check[y] = true;
                    dist[y] = dist[x] + z;
                    q.add(y);
                }
            }
        }

        return dist;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 트리 구현하기
        List<Edge>[] a = (List<Edge>[]) new List[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) break;
                int z = sc.nextInt();

                a[x].add(new Edge(y, z));
            }
        }

        int[] dist = bfs(n, a, 1);
        int start = 1;
        for (int i=2; i<=n; i++) {
            if (dist[start] < dist[i]) {
                start = i;
            }
        }

        dist = bfs(n, a, start);
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);


    }
}