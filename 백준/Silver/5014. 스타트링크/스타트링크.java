import java.util.*;
import java.io.*;
class Pair {
    int x, step;

    Pair(int x, int step) {
        this.x = x;
        this.step = step;
    }
}

public class Main {


    static boolean[] check;

    static char[] dir = {'u', 'd'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        check = new boolean[f+1];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s, 0));
        check[s] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int step = p.step;

            if (x == g && check[g] == true) {
                System.out.println(step);
                System.exit(0);
            }

            for (int k=0; k<2; k++) {
                char direction = dir[k];

                if (direction == 'u') {
                    int next = x+u;
                    if (1 <= next && next <= f && check[next] == false) {
                        q.add(new Pair(next, step+1));
                        check[next] = true;
                    }
                } else {
                    int next = x-d;
                    if (1 <= next && next <= f && check[next] == false) {
                        q.add(new Pair(next, step+1));
                        check[next] = true;
                    }
                }
            }

        }

        
        System.out.println("use the stairs");
        

    }
}