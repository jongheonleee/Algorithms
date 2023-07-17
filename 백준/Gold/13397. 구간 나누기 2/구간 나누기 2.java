import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;





public class Main {

    static boolean check(int[] a, int mid, int k) {
        int cnt = 1;
        int t1 = a[0];
        int t2 = a[0];

        for (int i=1; i<a.length; i++) {
            if (t1 > a[i]) t1 = a[i];
            if (t2 < a[i]) t2 = a[i];
            if (t2-t1 > mid) {
                cnt++;
                t1 = a[i];
                t2 = a[i];
            }
        }

        return cnt <= k;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        int left = 0, right = 0;
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
            right = a[i] > right ? a[i] : right;
        }

        int ans = right;
        while (left <= right) {
            int mid = (left+right)/2;

            if (check(a, mid, k)) {
                right = mid-1;
                ans = ans > mid ? mid : ans;
            } else {
                left = mid+1;
            }
        }
        System.out.println(ans);
    }
}