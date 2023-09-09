import java.io.*;
import java.util.*;



public class Main {

    static int[] processing(String p) {
        int m = p.length();
        int[] fail = new int[m];

        int j = 0;
        fail[0] = 0;

        for (int i=1; i<m; i++) {
            while (j>0 && p.charAt(i) != p.charAt(j)) {
                j = fail[j-1];
            }

            if (p.charAt(i) == p.charAt(j)) {
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
        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();

        int[] fail = processing(p);
        System.out.println(n - fail[n-1]);
    }
}