import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[][] sign;
    static int[] ans;

    static boolean check(int idx) {
        int sum = 0;
        for (int i=idx; i>=0; i--) {
            sum += ans[i];
            if (sign[i][idx] == 0) {
                if (sum != 0) return false;
            } else if (sign[i][idx] < 0) {
                if (sum >= 0) return false;
            } else {
                if (sum <= 0) return false;
            }
        }

        return true;
    }

    static boolean go(int idx) {
        if (idx == n) return true;

        if (sign[idx][idx] == 0) {
            ans[idx] = 0;
            return check(idx) & go(idx+1);
        }

        for (int i=1; i<=10; i++) {
            ans[idx] = sign[idx][idx]*i;
            if (check(idx) && go(idx+1)) return true;
        }

        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        sign = new int[n][n];

        String input = br.readLine();
        int cnt = 0;
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++) {
                char x = input.charAt(cnt);

                if (x == '0') sign[i][j] = 0;
                if (x == '+') sign[i][j] = 1;
                if (x == '-') sign[i][j] = -1;

                cnt++;
            }
        }
        go(0);
        for (int i=0; i<n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}