import java.io.*;
import java.util.*;


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int a = 10, b = 26, sd = 0, sc = 0, ans = 1;
        for (int i=0; i<str.length(); i++) {
            if (sd != 0 && str.charAt(i) == 'd') {
                ans *= (a-1);
                sd += 1;
            } else if (sc != 0 && str.charAt(i) == 'c') {
                ans *= (b-1);
                sc += 1;
            } else {
                if (str.charAt(i) == 'd') {
                    ans *= a; sd = 1; sc = 0;
                }
                else {
                    ans *= b; sc = 1; sd = 0;
                }
            }
        }

        System.out.println(ans);



    }
}