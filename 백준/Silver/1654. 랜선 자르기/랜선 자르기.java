import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static boolean check(long[] a, long len, int n) {
        int cnt = 0;

        for (int i=0; i<a.length; i++) {
            long left = a[i]/len;
            cnt += left;
        }

        return cnt >= n;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] a = new long[k];
        long max = 0;
        for (int i=0; i<k; i++) {
            a[i] = Long.parseLong(br.readLine());
            if (max < a[i]) max = a[i];
        }

        long left = 1, right = max, ans = 0;

        while (left <= right) {
            long mid = (left + right)/2;

            if (check(a, mid, n)) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }

        }

        System.out.println(ans);

    }
}