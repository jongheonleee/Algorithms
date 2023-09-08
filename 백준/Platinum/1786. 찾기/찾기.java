import java.io.*;
import java.util.*;


/**
 * KMP
 * - 1. processing -> make fail[]
 * - 2. kmp -> search p in s by using fail[]
 */
public class Main {

    static int cnt = 0;
    static int[] processing(String p){
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

    static ArrayList<Integer> kmp(String s, String p) {
        int[] fail = processing(p);
        int n = s.length(), m = p.length(), j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            while (j>0 && s.charAt(i) != p.charAt(j)) {
                j = fail[j-1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                if (j == m-1) {
                    ans.add(i-m+1);
                    j = fail[j];
                    cnt += 1;
                } else {
                    j += 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        ArrayList<Integer> ans = kmp(s, p);
        System.out.println(cnt);
        for (Integer idx : ans) {
            System.out.println(idx+1);
        }
    }
}