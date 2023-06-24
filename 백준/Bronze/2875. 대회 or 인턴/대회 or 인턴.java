import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        while (k > 0) {
            if (n > 2*m) {
                n--;
                k--;
            } else if (n < 2*m) {
                m--;
                k--;
            }
            else {
                if (k > 1) {
                    n--; m--;
                    k -= 2;
                } else {
                    n--;
                    k--;
                }
            }
        }

        int ans = 0;
        if (n == 0 || m == 0) {
            ans = 0;
        } else if (n >= 2*m) {
            ans = m;
        } else {
            ans = n/2;
        }

        System.out.println(ans);
    }
}