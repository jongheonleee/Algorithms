import java.util.*;
import java.io.*;


public class Main {


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        String line = br.readLine();
        boolean parentheses = false;
        int sum = 0, num = 0;

        for (char ch : line.toCharArray()) {
            if (ch == '+') {
                if (parentheses == true) {
                    sum += num;
                }
                else {
                    ans += num;
                }
                num = 0;
            } else if (ch == '-') {
                if (parentheses == false) {
                    ans += num;
                    parentheses = true;
                } else {
                    sum += num;
                    ans -= sum;
                }
                num = 0;
                sum = 0;
            } else {
                num = num*10 + (ch - '0');
            }
        }

        if (num != 0) {
            if (parentheses == true) {
                sum += num;
            } else {
                ans += num;
            }
        }

        if (sum != 0) {
            ans -= sum;
        }
        System.out.println(ans);



    }
}