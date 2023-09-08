import java.io.*;
import java.util.*;



public class Main {
    static final int BASE = 256;
    static final int MOD = 127;

    static int hash(String str) {
        int ans = 0;

        for (char ch : str.toCharArray()) {
            ans = (ans * BASE + ch) % MOD;
        }

        return ans;
    }

    static int search(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (n < m) return 0;

        int first = 1;
        for (int i=0; i<m-1; i++) {
            first = (first * BASE) % MOD;
        }

        int hashS = hash(s.substring(0, m));
        int hashP = hash(p);

        for (int i=0; i<=n-m; i++) {
            if (hashS == hashP) {
                if (p.equals(s.substring(i, i+m))) {
                    return 1;
                }
            }

            if (i+m < n) {
                hashS = (hashS - first * s.charAt(i)) % MOD;
                hashS = (hashS + MOD) % MOD;
                hashS = (hashS * BASE + s.charAt(i+m)) % MOD;
            }
        }

        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        System.out.println(search(s, p));
    }
}