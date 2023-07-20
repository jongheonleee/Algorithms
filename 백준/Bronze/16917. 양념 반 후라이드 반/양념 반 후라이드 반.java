import java.io.*;
import java.util.*;


public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ans = 0;

        if (x > 0 && y > 0) {
            int min = Math.min(x, y);
            if (2 * c >= a + b) {
                ans += a * min + b * min;
            } else {
                ans = 2 * c * min;
            }
            x -= min; y -= min;
        }

        if (x > 0) {
            if (2*c >= a) {
                ans += a * x;
            } else {
                ans += 2 * c * x;
            }
        }

        if (y > 0) {
            if (2*c >= b) {
                ans += b * y;
            } else {
                ans += 2 * c * y;
            }
        }

        System.out.println(ans);
        

    }
}