import java.util.*;
import java.io.*;


public class Main {

    private static int[] set;
    private static int ans;
    private static void go(int n, int curr) {
        if (n < curr) return;

        if (ans < curr) ans = curr;

        for (int i=set.length-1; i>=0; i--) {
            go(n, curr * 10 + set[i]);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);

        set = new int[k];
        for (int i=0; i<k; i++) {
            set[i] = Integer.parseInt(line2[i]);
        }
        go(n, 0);
        System.out.println(ans);
    }
}
