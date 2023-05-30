import java.util.*;
import java.io.*;
public class Main {
    static int cnt = 0;

    static void go(int[] a, int idx, int s, int sum) {
        if (idx == a.length) {
            if (s == sum) {
                cnt++;
            }
            return;
        }

        go(a, idx+1, s, sum+a[idx]);
        go(a, idx+1, s, sum);
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]), s = Integer.parseInt(line1[1]);
        int[] a = new int[n];

        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }

        go(a, 0, s, 0);
        if (s == 0) cnt--;
        System.out.println(cnt);


    }
}