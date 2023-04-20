import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] a;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        a = new int[n+1];
        for (int i=1; i<=n; i++) a[i] = i;
        dfs(1, m, "");
        System.out.println(sb);
    }

    public static void dfs(int prevIdx, int m, String crnt) {
        if ( m == 0) {
            sb.append(crnt).append("\n");
            return;
        }

        for (int i=prevIdx; i<=a.length-1; i++) {
            String prev = crnt;
            crnt += a[i] + " ";
            dfs( i, m-1, crnt);
            crnt = prev;
        }
    }
}