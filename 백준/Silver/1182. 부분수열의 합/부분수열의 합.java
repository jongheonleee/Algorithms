import java.util.*;
import java.io.*;
public class Main {

    static int cnt = 0;

    static void go(int[] a, int i, int sum, int s) {
        if (i == a.length) {
            if (sum == s) {
                cnt++;
            }

            return;
        }

        go(a, i+1, sum+a[i], s);
        go(a, i+1, sum, s);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]), s = Integer.parseInt(line[1]);
        int[] a = new int[n];

        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }

        go(a, 0, 0, s);
        
        if (s == 0) cnt--;
        System.out.println(cnt);

    }
}