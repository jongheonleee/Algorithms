import java.io.*;
import java.util.*;

public class Main {

    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    static String cut(String str) {
        return str.substring(0, str.length()-1);
    }

    static boolean can(String s, String t) {
        if (s.equals(t)) {
            return true;
        }

        if (t.length() > 0) {
            if (t.charAt(t.length()-1) == 'A' && can(s, cut(t))) {
                return true;
            }
            if (t.charAt(0) == 'B' && can(s, cut(reverse(t)))) {
                return true;
            }
        }


        return false;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int ans = (can(s, t) ? 1 : 0);
        System.out.println(ans);

    }
}