import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 1. 방 구현
 * 2. 문, 거울을 그래프로 구현
 * 3. bfs 탐색을 통해 결과 출력
 */

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1~2. 방 구현 및 그래프 구현
        String[] room = new String[n];
        ArrayList<Node> graph = new ArrayList<>();
        int[][] nodeNumber = new int[n][n];
        int startNumber = -1, endNumber = -1;
        for (int i=0; i<n; i++) {
            room[i] = br.readLine();

            for (int j=0; j<n; j++) {
                char ch = room[i].charAt(j);

                if (ch == '#') {
                    if (startNumber == -1) {
                        startNumber = graph.size();
                    } else {
                        endNumber = graph.size();
                    }
                    graph.add(new Node(i, j));
                    nodeNumber[i][j] = graph.size()-1;
                } else if (ch == '!') {
                    graph.add(new Node(i, j));
                    nodeNumber[i][j] = graph.size()-1;
                }
            }
        }


        // 간선, 노드끼리 연결 해주기
        int m = graph.size();
        boolean[][] edges = new boolean[m][m];
        for (int from=0; from<m; from++) {
            Node node = graph.get(from);

            for (int k=0; k<4; k++) {
                int x = node.x + dx[k];
                int y = node.y + dy[k];

                while (0 <= x && x < n && 0 <= y && y < n) {
                    char ch = room[x].charAt(y);
                    int to = nodeNumber[x][y];
                    
                    if (ch == '!' || ch == '#') {
                        edges[from][to] = true;
                    } else if (ch == '*') {
                        break;
                    }
                    
                    x += dx[k];
                    y += dy[k];
                }
            }
        }


        // 3. bfs 탐색
        int[] dist = new int[m];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(startNumber);
        dist[startNumber] = 0;

        while (!q.isEmpty()) {
            int from = q.remove();

            for (int to=0; to<m; to++) {
                if (edges[from][to] && dist[to] == -1) {
                    dist[to] = dist[from]+1;
                    q.add(to);
                }
            }
        }

        System.out.println(dist[endNumber]-1);


    }

}