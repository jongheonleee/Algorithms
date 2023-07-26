import java.io.*;
import java.util.*;

public class Main {

    static int n, l, r, x, ans;

    static int[] a = new int[15];
    static boolean[] selected = new boolean[15];

    static void go(int idx) {
        if (idx == n) {
            int easy = -1;
            int hard = -1;
            int sum = 0;
            int cnt = 0;
            for (int i=0; i<n; i++) {
                if (selected[i] == true) {
                    cnt++;
                    sum += a[i];
                    if (easy == -1 || easy > a[i]) easy = a[i];
                    if (hard == -1 || hard < a[i]) hard = a[i];
                }
            }

            if (l <= sum && sum <= r &&
                    hard - easy >= x && cnt >= 2) ans++;
            return;
        }

        selected[idx] = true;
        go(idx+1);

        selected[idx] = false;
        go(idx+1);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ans = 0;

        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }


        go(0);
        System.out.println(ans);
    }
}