import java.io.*;

public class Main {
    static int limit = 15;
    static int[] t = new int[limit+1];
    static int[] p = new int[limit+1];
    static int result = 0;


    public static void go(int day, int price, int n) {
        if (day == n+1) {
            result = result < price ? price : result;
            return;
        }

        if (day > n+1) return;

        go(day+t[day], price+p[day], n);
        go(day+1, price, n);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++) {
            String[] line = br.readLine().split(" ");
            t[i] = Integer.parseInt(line[0]);
            p[i] = Integer.parseInt(line[1]);
        }

        go(1, 0, n);
        System.out.println(result);

    }
}