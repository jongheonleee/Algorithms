import java.io.*;
import java.util.*;


public class Main {

    static boolean check(long mid, long n, long k) {
        long idx = 0;

        for (long i=1; i<=n; i++) {
            idx += Math.min(n, mid/i);
        }

        return idx >= k;
    }



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()), k = Long.parseLong(br.readLine());

        long left = 1, right = n*n, ans = 1;
        while (left <= right) {
            long mid = (left+right)/2;

            if (check(mid, n, k)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
            
        }

        System.out.println(ans);

    }
}