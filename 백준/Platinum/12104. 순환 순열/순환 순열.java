import java.io.*;
import java.util.*;

public class Main {

    static int[] preprocessing(String p) {
        int m = p.length();
        int[] fail = new int[m];

        int j = 0;
        fail[0] = 0;

        for (int i=1; i<m; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
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

    static ArrayList<Integer> kmp(String s, String p) {
        int[] fail = preprocessing(p);
        int n = s.length();
        int m = p.length();
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = fail[j-1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                if (j == m-1) {
                    ans.add(i-m+1);
                    j = fail[j];
                }
                else {
                    j += 1;
                }
            }
        }

        return ans;
    }




    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        b = b + b;
        b = b.substring(0, b.length()-1);
        ArrayList<Integer> ans = kmp(b, a);
        System.out.println(ans.size());
    }
}