import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] a;
    static String[] line;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(a);
        dfs(m, "");
        System.out.println(sb);

    }

    public static void dfs(int m, String crnt) {
        if (m == 0) {
            sb.append(crnt).append("\n");
            return;
        }

        for (int i=0; i<=a.length-1; i++) {
            if (a[i] != -1) {
                int tmp = a[i];
                String prev = crnt;

                crnt += tmp + " ";
                a[i] = -1;
                dfs(m-1, crnt);

                crnt = prev;
                a[i] = tmp;
            }
        }
    }
}
