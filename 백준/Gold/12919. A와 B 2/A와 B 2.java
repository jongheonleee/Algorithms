import java.util.*;
public class Main {
    public static String cut(String s) {
        return s.substring(0, s.length()-1);
    }
    public static String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public static boolean can(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (t.length() > 0) {
            if (t.charAt(t.length()-1) == 'A' && can(s, cut(t))) {
                return true;
            }
            if (t.charAt(0) == 'B' && can(s, cut(rev(t)))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(can(s, t) ? 1 : 0);
    }
}