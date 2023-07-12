import java.util.*;

public class Main {
    static long calc(int n) {
        long ans = 0;
        for (int start=1, len=1; start<=n; start*=10, len++) {
            int end = start*10-1;
            if (end > n) {
                end = n;
            }
            ans += (long)(end - start + 1) * len;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        if (calc(n) < k) {
            System.out.println(-1);
            System.exit(0);
        }
        int left = 1;
        int right = n;
        int ans = 0;
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
        System.out.println(s.charAt(s.length()-(int)(l-k)-1));
    }
}