import java.util.*;
import java.io.*;
import java.util.Map.Entry;


public class Main {

    private static String cut(String s) {
        return s.substring(0, s.length()-1);
    }
    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    private static boolean check(String s, String t) {
        if (s.equals(t)) return true;

        if (t.length() > 0) {
            if (t.charAt(t.length()-1) == 'A' && check(s, cut(t))) {
                return true;
            }

            if (t.charAt(0) == 'B' && check(s, cut(reverse(t)))) {
                return true;
            }
        }

        return false;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(check(s, t) ? 1 : 0);
    }
}


