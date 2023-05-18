import java.util.*;
import java.io.*;
public class Main {

    static final int LIMIT = 1000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int src = Integer.parseInt(line[0]), dest = Integer.parseInt(line[1]);

        int[] time = new int[LIMIT+1];
        Arrays.fill(time, -1);

        Queue<Integer> currentQ = new LinkedList<>(), nextQ = new LinkedList<>();
        currentQ.add(src);
        time[src] = 0;

        while (!currentQ.isEmpty()) {
            int current = currentQ.remove();

            for (int next : new int[]{current-1, current+1, current*2}) {
                if (0 <= next && next <= LIMIT && time[next] == -1) {
                    if (next == current*2) {
                        time[next] = time[current];
                        currentQ.add(next);
                    }

                    else {
                        time[next] = time[current]+1;
                        nextQ.add(next);
                    }
                }
            }

            if (currentQ.isEmpty()) {
                currentQ = nextQ;
                nextQ = new LinkedList<>();
            }
        }

        System.out.println(time[dest]);

    }
}