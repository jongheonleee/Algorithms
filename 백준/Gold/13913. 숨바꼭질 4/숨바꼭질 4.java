import java.util.*;
import java.io.*;


public class Main {

    static final int LIMIT = 100000;
    static int[] from = new int[LIMIT+1];
    static int[] dist = new int[LIMIT+1];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");

        int src = Integer.parseInt(line[0]);
        int dest = Integer.parseInt(line[1]);

        Queue<Integer> q = new LinkedList<>();
        // 시작점 담아주기
        q.add(src);
        from[src] = -1; dist[src] = 0;

        // bfs 알고리즘 적용
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (curr == dest) break;

            if (curr-1 >= 0 && dist[curr-1] == 0) {
                dist[curr-1] = dist[curr]+1;
                from[curr-1] = curr;

                q.add(curr-1);
            }

            if (curr+1 <= LIMIT && dist[curr+1] == 0) {
                dist[curr+1] = dist[curr]+1;
                from[curr+1] = curr;

                q.add(curr+1);
            }

            if (2*curr <= LIMIT && dist[2*curr] == 0) {
                dist[2*curr] = dist[curr]+1;
                from[2*curr] = curr;

                q.add(2*curr);
            }
        }

        // 경로 출력
        Stack<Integer> stack = new Stack<>();

        for (int i=dest; i!=src; i=from[i]) {
            stack.push(i);
        }
        stack.push(src);

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(dist[dest]);
        System.out.println(sb);
    }
}