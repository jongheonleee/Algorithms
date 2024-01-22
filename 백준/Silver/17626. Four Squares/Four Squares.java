import java.util.*;
import java.io.*;



public class Main {

    private static int n;
    private static int ans;

    private static void go(int start, int sum, int count) {
        if (sum == n) {
            if (count <= ans) {
                ans = count;
            }
            return;
        }

        if (sum > n || count >= 4) return;

        for (int i=1; i<=start; i++) {
            go(i, sum+(i*i), count+1);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 4;
        go(224, 0, 0);
        System.out.println(ans);
    }
}

