import java.io.*;
import java.util.*;





public class Main {

    static int base = 256;
    static int mod = 127;

    static int hash(String str) {
        int ans = 0;

        for (char ch : str.toCharArray()) {
            ans = (ans * base + ch) % mod;
        }

        return ans;
    }

    static int match(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (n < m) return 0;

        int first = 1;
        int hashS = hash(s.substring(0, m));
        int hashP = hash(p);

        for (int i=0; i<m-1; i++) {
            first = (first * base) % mod;
        }


        for (int i=0; i<=n-m; i++) {
            if (hashS == hashP) {
                if (p.equals(s.substring(i, i+m))) {
                    return 1;
                }
            }

            if (i+m < n) {
                hashS = hashS-(s.charAt(i)*first)%mod;
                hashS = (hashS+mod)%mod;
                hashS = ((hashS*base)%mod + s.charAt(i+m))%mod;
            }
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        System.out.println(match(s, p));
    }
}