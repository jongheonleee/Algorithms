import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] a = new int[10];
    static int [] num = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void go(int idx, int start, int n, int m) {
        if (idx == m) {
            for (int i=0; i<m; i++) {
                sb.append(num[a[i]]);
                if (i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<n; i++) {
            a[idx] = i;
            go(idx+1, i+1, n, m);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]);
        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            num[i] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(num, 0, n);
        go(0, 0, n, m);
        System.out.println(sb);

    }
}