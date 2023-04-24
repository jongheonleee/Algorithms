import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] a = new int[10];
//    static boolean[] c = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void go(int idx, int prevIdx, int n, int m) {
        if (idx == m) {
            for (int i=0; i<=m-1; i++) {
                sb.append(a[i]);
                if (!(i == m-1)) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=prevIdx+1; i<=n; i++) {
            a[idx] = i;
            go(idx+1, i, n, m);

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        go(0, 0, n, m);
        System.out.println(sb);

    }
}