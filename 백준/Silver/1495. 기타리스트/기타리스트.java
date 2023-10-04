import java.util.*;
import java.io.*;



public class Main {

    static int n, s, m;
    static int[] v;
    static boolean[][] d;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new int[n+1];
        d = new boolean[1001][1001];

        String[] line = br.readLine().split(" ");
        for (int i=1; i<=n; i++) {
            v[i] = Integer.parseInt(line[i-1]);
        }

        Queue<Integer> q = new LinkedList<>();
        d[0][s] = true;
        q.add(s);

        for (int i=1; i<=n; i++) {
            int len = q.size();
            while (len-- > 0) {
                int x = q.remove();
                int nx1 = x+v[i];
                int nx2 = x-v[i];

                if (0 <= nx1 && nx1 <= m) {
                    if (!d[i][nx1]) {
                        d[i][nx1] = true;
                        q.add(nx1);
                    }
                }
                if (0 <= nx2 && nx2 <= m) {
                    if (!d[i][nx2]) {
                        d[i][nx2] = true;
                        q.add(nx2);
                    }
                }
            }
        }

        int ans = -1;
        for (int i=0; i<1001; i++) {
            if (i <= m && d[n][i]) {
                if (ans == -1 || ans < i) ans = i;
            }
        }

        System.out.println(ans);


    }
}
