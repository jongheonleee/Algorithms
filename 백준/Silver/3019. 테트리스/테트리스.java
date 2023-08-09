import java.util.*;
import java.io.*;

public class Main {

    static int n, m;

    static int[] a;

    static int calc(int i, String s) {
        if (i + s.length() > n) return 0;

        int base = a[i] - (s.charAt(0) - '0');

        for (int j=0; j<s.length(); j++) {
            if (base != a[i+j] - (s.charAt(j) - '0')) return 0;
        }

        return 1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            if (m == 1) {
                ans += calc(i, "0");
                ans += calc(i, "0000");
            } else if (m == 2) {
                ans += calc(i, "00");
            } else if (m == 3) {
                ans += calc(i, "001");
                ans += calc(i, "10");
            } else if (m == 4) {
                ans += calc(i, "100");
                ans += calc(i, "01");
            } else if (m == 5) {
                ans += calc(i, "000");
                ans += calc(i, "01");
                ans += calc(i, "101");
                ans += calc(i, "10");
            } else if (m == 6) {
                ans += calc(i, "000");
                ans += calc(i, "00");
                ans += calc(i, "011");
                ans += calc(i, "20");
            } else {
                ans += calc(i, "000");
                ans += calc(i, "00");
                ans += calc(i, "110");
                ans += calc(i, "02");
            }
        }
        System.out.println(ans);
    }
}