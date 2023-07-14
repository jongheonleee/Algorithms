import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static long calc(int n) {
        long ans = 0;

        for (int start=1, len=1; start<=n; start*=10, len++) {
            int end = start*10-1;
            if (end > n) {
                    end = n;
            }

            ans += (long)(end-start+1)*len;
        }
        
        return ans;
    }

    static boolean check(int n, long k) {
        long cnt = calc(n);
        return cnt>=k;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        if (k > calc(n)) {
            System.out.println(-1);
            System.exit(0);
        }

        int left = 1, right = n, ans = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (check(mid, k)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }


        String s = Integer.toString(ans);
        long l = calc(ans);
        int idx = s.length() - (int)(l-k+1);
        System.out.println(s.charAt(idx));



    }
}