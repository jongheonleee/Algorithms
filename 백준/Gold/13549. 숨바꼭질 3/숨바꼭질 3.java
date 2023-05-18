import java.util.*;
import java.io.*;
public class Main {

    static final int LIMIT = 1000000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int src = Integer.parseInt(line[0]), dest = Integer.parseInt(line[1]);

        boolean[] check = new boolean[LIMIT];
        int[] time = new int[LIMIT];

        check[src] = true; time[src] = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(src);

        while (!q1.isEmpty()) {
            int curr = q1.remove();

            for (int next : new int[] {curr*2, curr-1, curr+1}) {
                if (next >= 0 && next < LIMIT) {
                    if (check[next] == false) {
                        check[next] = true;

                        if (curr*2 == next) {
                            q1.add(next);
                            time[next] = time[curr];
                        }
                        else {
                            q2.add(next);
                            time[next] = time[curr]+1;
                        }
                    }
                }
            }
            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }
        System.out.println(time[dest]);

    }
}