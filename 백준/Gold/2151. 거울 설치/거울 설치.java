import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Pair {
    int x, y;

    Pair (int x, int y) {
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

        String[] room = new String[n];
        int start = -1, end = -1;
        int[][] number = new int[n][n];
        ArrayList<Pair> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            room[i] = br.readLine();

            for (int j=0; j<n; j++) {
                char ch = room[i].charAt(j);

                if (ch == '#') {
                    if (start == -1) {
                        start = graph.size();
                    } else {
                        end = graph.size();
                    }

                    graph.add(new Pair(i, j));
                    number[i][j] = graph.size()-1;
                }else if (ch == '!') {
                    graph.add(new Pair(i, j));
                    number[i][j] = graph.size()-1;
                }
            }
        }

        int m = graph.size();
        boolean[][] edges = new boolean[m][m];

        for (int i=0; i<m; i++) {
            Pair p = graph.get(i);

            for (int k=0; k<4; k++) {
                int x = p.x+dx[k];
                int y = p.y+dy[k];

                while(0 <= x && x < n && 0 <= y && y < n) {
                    char ch = room[x].charAt(y);

                    if (ch == '*') break;
                    if (ch == '!' || ch == '#') {
                        edges[i][number[x][y]] = true;
                    }
                    x += dx[k];
                    y += dy[k];
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[m];
        Arrays.fill(dist, -1);
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.remove();
            for (int i=0; i<m; i++) {
                if (edges[now][i] && dist[i] == -1) {
                    dist[i] = dist[now]+1;
                    q.add(i);
                }
            }
        }

        System.out.println(dist[end]-1);


    }

}