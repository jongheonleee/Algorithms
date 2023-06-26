import java.util.*;
import java.io.*;

public class Main {

    static final int IMPOSSIBLE = 0;
    static final int POSSIBLE = 1;

    static String popBack(String str) {
        return str.substring(0, str.length()-1);

    }

    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String src = br.readLine();
        String dst = br.readLine();

        while (src.length() < dst.length()) {
            if (dst.charAt(dst.length()-1) == 'A') {
                dst = popBack(dst);
            }

            else {
                dst = popBack(dst);
                dst = reverse(dst);
            }
        }

        if (src.equals(dst) == true) {
            System.out.println(POSSIBLE);
        } else {
            System.out.println(IMPOSSIBLE);
        }

    }
}