import java.util.*;
import java.io.*;


public class Main {
    


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i=1; i<=n; i++) {
            int tmp = i;
            int sum = 0;
            while (tmp > 0) {
                sum += tmp%10;
                tmp /= 10;
            }

            if (n == i + sum) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }
}