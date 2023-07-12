import java.util.*;
import java.io.*;




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

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        long k = Long.parseLong(line[1]);

        if (k > calc(n)) {
            System.out.println(-1);
            System.exit(0);
        }

        int left = 1, right = n, ans = 0;

        while (left <= right) {
            int mid = (left+right)/2;
            long len = calc(mid);

            if (len < k) {
                left = mid+1;
            } else {
                ans = mid;
                right = mid-1;
            }
        }

        String s = Integer.toString(ans);
        long l = calc(ans);

        System.out.println(s.charAt(s.length()-(int)(l-k+1)));

    }
}