import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int m;
    static int ans;
    static int[] arr;

    private static void go(int i, int sum, int cnt) {
        if (cnt == 3) {
            if (sum >= ans && sum <= m) ans = sum;
            return;
        }

        if (i < arr.length) {
            go(i+1, sum+arr[i], cnt+1);
            go(i+1, sum, cnt);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        arr = new int[line2.length];

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }

        go(0, 0, 0);
        System.out.println(ans);

    }
}