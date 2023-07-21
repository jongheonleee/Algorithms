import java.io.*;
import java.util.*;



public class Main {

    static int[] a;
    static int n, l, r, x;
    static boolean isValidRange(int[] t) {
        int sum = 0;
        for (int i=0; i<t.length; i++) {
            sum += t[i];
        }

        return l <= sum && sum <= r;
    }

    static boolean isValidDiff(int[] t) {
        Arrays.sort(t);
        return t[t.length-1] - t[0] >= x;
    }

    static boolean go(int bit) {
        int c = 0;

        for (int i=0; i<n; i++) {
            int selected = (bit & (1<<i));
            if (selected != 0) {
                c++;
            }
        }

        int[] t = new int[c];
        for (int i=0, j=0; i<n; i++) {
            int selected = (bit & (1<<i));
            if (selected != 0) {
                t[j] = a[i];
                j++;
            }
        }

        return isValidRange(t) && isValidDiff(t);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        n = Integer.parseInt(line1[0]);
        l = Integer.parseInt(line1[1]);
        r = Integer.parseInt(line1[2]);
        x = Integer.parseInt(line1[3]);

        a = new int[n];
        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }

        int ans = 0;
        for (int k=0; k<(1<<n); k++) {
            if (go(k)) {
                int cnt = 0;
                for (int i=0; i<n; i++) {
                    if ((k&(1<<i)) != 0) {
                        cnt++;
                    }
                }
                if (cnt >= 2) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}