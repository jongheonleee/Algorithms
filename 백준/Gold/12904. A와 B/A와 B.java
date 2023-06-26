import java.util.*;
public class Main {
    public static String pop_back(String s) {
        return s.substring(0, s.length()-1);
    }
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        while (t.length() > s.length()) {
            if (t.charAt(t.length()-1) == 'A') {
                t = pop_back(t);
            } else {
                t = pop_back(t);
                t = reverse(t);
            }
        }
        if (s.equals(t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}