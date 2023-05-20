import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 트리 구현
        ArrayList<Integer>[] a = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList();
        }

        for (int i=0; i<n-1; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]), v = Integer.parseInt(line[1]);

            a[u].add(v); a[v].add(u);
        }

        boolean[] check = new boolean[n+1];
        int[] parent = new int[n+1];

        // bfs 알고리즘으로 각 정점의 부모 찾아서 저장해주기
        Queue<Integer> q = new LinkedList<>();
        q.add(1); check[1] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }

        for (int i=2; i<=n; i++) {
            System.out.println(parent[i]);
        }

    }
}