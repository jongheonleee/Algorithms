import java.io.*;
import java.util.*;



public class Main {

    static int[] processing(String p) {
        int m = p.length();
        int[] fail = new int[m];

        int j = 0; fail[0] = 0;

        for (int i=1; i<m; i++) {
            while (j>0 && p.charAt(j) != p.charAt(i)) {
                j = fail[j-1];
            }

            if (p.charAt(j) == p.charAt(i)) {
                fail[i] = j+1;
                j = j+1;
            } else {
                fail[i] = 0;
            }
        }

        return fail;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String tmp = "";

        int ans = 0;
        for (int i=s.length()-1; i>=0; i--) {
            tmp = s.charAt(i) + tmp;
            int[] fail = processing(tmp);
            for (int j=0; j< fail.length; j++) {
                if (ans < fail[j]) {
                    ans = fail[j];
                }
            }
        }

        System.out.println(ans);

    }
}