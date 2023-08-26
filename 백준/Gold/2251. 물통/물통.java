import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class State {
    int a, b;

    State(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {

    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[] ans = new boolean[201];
        boolean[][] check = new boolean[201][201];
        int[] cap = new int[3];
        cap[0] = a;
        cap[1] = b;
        cap[2] = c;
        int sum = c;

        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0));
        ans[sum] = true;
        check[0][0] = true;

        while (!q.isEmpty()) {
            State s = q.remove();
            int stateA = s.a;
            int stateB = s.b;
            int stateC = sum - (stateA + stateB);

            for (int k=0; k<6; k++) {
                int[] nextState = {stateA, stateB, stateC};
                // i -> j
                int i = from[k];
                int j = to[k];

                nextState[j] += nextState[i];
                nextState[i] = 0;

                if (nextState[j] >= cap[j]) {
                    nextState[i] = nextState[j] - cap[j];
                    nextState[j] = cap[j];
                }

                if (!check[nextState[0]][nextState[1]]) {
                    check[nextState[0]][nextState[1]] = true;
                    q.add(new State(nextState[0], nextState[1]));
                    if (nextState[0] == 0 && ans[nextState[2]] == false) {
                        ans[nextState[2]] = true;
                    }
                }
            }
        }

        for (int i=0; i<=c; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }




    }
}