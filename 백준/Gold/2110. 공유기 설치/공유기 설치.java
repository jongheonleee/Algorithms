import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static boolean possible(int[] a, int k, int c) {
        int cnt = 1;
        int last = a[0];

        for (int h : a) {
            if (h - last >= k) {
                cnt++;
                last = h;
            }
        }

        return cnt >= c;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());
        Arrays.sort(a);

        int left = 1, right = a[n-1]-a[0], ans = 0;

        while (left <= right) {
            int mid = (left+right)/2;

            if (possible(a, mid, c)) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(ans);


    }
}