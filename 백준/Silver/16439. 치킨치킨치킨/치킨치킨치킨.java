import java.util.*;
import java.io.*;



public class Main {

    static int n, m, ans;
    static int[][] users;
    static void go(int idx, int cnt, ArrayList<Integer> selected) {
        if (idx == m) {
            if (cnt == 3) {
                int tmp = calc(selected);
                if (ans < tmp) ans = tmp;
            }

            return;
        }

        if (cnt == 3) {
            int tmp = calc(selected);
            if (ans < tmp) ans = tmp;
            return;
        }

        // selected
        selected.add(idx);
        go(idx+1, cnt+1, selected);

        selected.remove(selected.size()-1);
        go(idx+1, cnt, selected);

    }


    static int calc(ArrayList<Integer> selected) {
        int ans = 0;

        for (int i=0; i< users.length; i++) {
            int max = 0;
            for (int j : selected) {
                if (max < users[i][j]) max = users[i][j];
            }

            ans += max;
        }

        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        users = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                users[i][j] = Integer.parseInt(line[j]);
            }
        }

        go(0, 0, new ArrayList<>());
        System.out.println(ans);

    }
}