import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static boolean check(long[] a, long h, long m) {
        long ans = 0;

        for (int i=0; i<a.length; i++) {
            if (a[i] - h > 0) {
                ans += a[i] - h;
            }
        }

        return ans >= m;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        long m = Long.parseLong(line1[1]);

        String[] line2 = br.readLine().split(" ");
        long max = 0;
        long[] a = new long[n];
        for (int i=0; i<n; i++) {
            a[i] = Long.parseLong(line2[i]);
            if (max < a[i]) max = a[i];
        }

        long left = 0, right = max, ans = 0;

        while (left <= right) {
            long mid = (left+right)/2;

            if (check(a, mid, m)) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(ans);
        
    }
}