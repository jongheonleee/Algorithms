import java.util.*;
import java.io.*;

class Info {
    String com;
    int strike, ball;

    Info() {

    }

    Info(int number, int s, int b) {
        this.com = number + "";
        this.strike = s;
        this.ball = b;
    }

    public boolean isPossible(String str) {
        int s = 0, b = 0;

        for (int i=0; i<str.length(); i++) {
            for (int j=0; j<com.length(); j++) {
                if (i==j && str.charAt(i) == com.charAt(j)) {
                    s++;
                } else if (str.charAt(i) == com.charAt(j)) {
                    b++;
                }
            }
        }

        return (s == strike && b == ball);
    }
}


public class Main {

    private static boolean[] isUsed = new boolean[10];
    private static Info[] information;
    private static int ans = 0;
    private static void go(int i, String number) {
        if (i == 3) {
            boolean ok = true;
            for (int j=0; j< information.length; j++) {
                if (!information[j].isPossible(number)) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans++;
            return;
        }

        for (int j=1; j<10; j++) {
            if (isUsed[j]) continue;

            isUsed[j] = true;
            go(i+1, number+j);
            isUsed[j] = false;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        information = new Info[n];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            int number = Integer.parseInt(line[0]);
            int strike = Integer.parseInt(line[1]);
            int ball = Integer.parseInt(line[2]);
            information[i] = new Info(number, strike, ball);
        }

        go(0, "");
        System.out.println(ans);
    }

}
