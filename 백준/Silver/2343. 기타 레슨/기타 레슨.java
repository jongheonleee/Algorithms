import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;





public class Main {

    static boolean isPossible(int[] a, int k) {
        for (int i=0; i<a.length; i++) {
            if (a[i] > k) return false;
        }

        return true;
    }


    static boolean check(int[] a, int k, int m) {
        if (isPossible(a, k) == false) return false;

        int acc = 0, cnt = 1;

        for (int i=0; i<a.length; i++) {
            if (acc + a[i] <= k) {
                acc += a[i];
            } else {
                cnt += 1;
                acc = a[i];
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
        int sum = 0, min = -1;
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
            sum += a[i];
            if (min == -1 || min != -1 && min > a[i]) min = a[i];
        }


        int left = min, right = sum, ans = 0;

        while (left <= right) {
            int mid = (left+right)/2;

            if (check(a, mid, m)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);

    }
}