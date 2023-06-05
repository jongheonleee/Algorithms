import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static int[][] a;
    static int ans = 0;

    static void go(int day, int price) {
        // 종료 조건
        if (day == n+1) {
            if (ans < price)
                ans = price;
            return;
        }

        if (day > n+1)
            return;

        go(day+1, price);
        go(day+a[0][day], price+a[1][day]);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            String[] line = br.readLine().split(" ");
            a[0][i] = Integer.parseInt(line[0]);
            a[1][i] = Integer.parseInt(line[1]);
        }

        go(1, 0);
        System.out.println(ans);
    }
}