import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[f+1];
        int[] dist = new int[f+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        check[s] = true;
        dist[s] = 0;

        while (!q.isEmpty()) {
            int now = q.remove();

            int up = now + u;
            int down = now - d;

            if (1 <= up && up <= f && check[up] == false) {
                check[up] = true;
                dist[up] = dist[now]+1;
                q.add(up);
            }

            if (1 <= down && down <= f && check[down] == false) {
                check[down] = true;
                dist[down] = dist[now]+1;
                q.add(down);
            }
        }

        if (check[g]) {
            System.out.println(dist[g]);
        } else {
            System.out.println("use the stairs");
        }
    }
}