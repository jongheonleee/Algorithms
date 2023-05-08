import java.util.*;
import java.io.*;

// 간선 리스트를 구현할 때 사용하는 노드
class Edge {
    int from, to;

    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        // 인접 행렬부터 구현
        boolean[][] a = new boolean[n][n];

        // 인접 리스트 구현
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];

        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 간선 리스트 구현
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i=0; i<m; i++) {
            line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]), to = Integer.parseInt(line[1]);
            a[from][to] = a[to][from] = true;
            graph[from].add(to); graph[to].add(from);
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
        }

        m *= 2;
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if (A == B || A == C || A == D ||B == C || B == D || C == D)
                    continue;

                if (!a[B][C])
                    continue;

                for (int E : graph[D]) {
                    if (E == A || E == B || E == C || E == D) continue;
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}