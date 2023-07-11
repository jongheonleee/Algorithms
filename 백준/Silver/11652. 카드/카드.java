import java.util.*;
import java.io.*;


public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];

        for (int i=0; i<n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(a);
        long ans = a[0];
        int ans_cnt = 1;
        int cnt = 1;

        for (int i=1; i<n; i++) {
            if (a[i] == a[i-1]) {
                cnt++;
            } else {
                cnt=1;
            }

            if (ans_cnt < cnt) {
                ans_cnt = cnt;
                ans = a[i];
            }
         }
        System.out.println(ans);

    }
}