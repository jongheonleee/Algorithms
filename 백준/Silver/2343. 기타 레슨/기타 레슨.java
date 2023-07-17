import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;





public class Main {

    static final int INIT = -1;
    static boolean check(int[] a, int k, int m) {
        int acc = 0, cnt = 1;

        for (int i=0; i<a.length; i++) {
            if (acc + a[i] > k) {
                cnt+= 1;
                acc = a[i];
            }
            else {
                acc += a[i];
            }
        }

        return cnt <= m;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        int left = INIT, right = 0, ans = 0;
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
            if (left == INIT || left != INIT && left < a[i]) left = a[i];
            right += a[i];
        }

        while (left <= right) {
            int mid = (left+right)/2;

            if (check(a, mid, m)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        System.out.println(ans);
    }
}