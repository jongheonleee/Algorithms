import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int[][] sign;
    static int[] a;
    static int n;

    static boolean check(int idx) {
        int sum = 0;

        for (int i=idx; i>=0; i--) {
            sum += a[i];
            if (sign[i][idx] == 0) {
                if (sum != 0) return false;
            }
            if (sign[i][idx] > 0) {
                if (sum <= 0) return false;
            }
            if (sign[i][idx] < 0) {
                if (sum >= 0) return false;
            }
        }

        return true;
    }

    static boolean go(int idx) {
        if (idx == n) return true;

        if (sign[idx][idx] == 0) {
            a[idx] = 0;
            return check(idx) && go(idx+1);
        }

        for (int i=1; i<=10; i++) {
            a[idx] = i * sign[idx][idx];
            if (check(idx) && go(idx+1)) return true;
        }

        return false;
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        a = new int[n]; sign = new int[n][n];
        String line = br.readLine();

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                char ch = line.charAt(cnt);

                if (ch == '0') {
                    sign[i][j] = 0;
                } else if (ch == '-') {
                    sign[i][j] = -1;
                } else {
                    sign[i][j] = 1;
                }

                cnt++;
            }
        }

        go(0);
        for (int i=0; i<n; i++) {
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb);

    }
}