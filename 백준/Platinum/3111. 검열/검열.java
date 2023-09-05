import java.io.*;
import java.util.*;
public class Main {
    // left/right
    static char[] l = new char[300001];
    static char[] r = new char[300001];
    // ln and rn are length of left/right
    static int ln = 0, rn = 0;
    // given word = A
    static char[] a;
    // reverce given word = A
    static char[] ar;
    // Text
    static char[] b;
    // n is length of given word, m is length of given text
    static int n, m;

    static boolean check(int where) {
        char[] stack = l;
        int len = ln;
        char[] str = ar;

        if (where == 1) {
            stack = r;
            len = rn;
            str = a;
        }

        if (len-n < 0) {
            return false;
        }

        for (int i=0; i<n; i++) {
            if (stack[len-i-1] != str[i]) {
                return false;
            }
        }
        if (where == 0) {
            ln -= n;
        } else {
            rn -= n;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = br.readLine().toCharArray();
        n = a.length;
        ar = new char[n];
        for (int i=0; i<n; i++) {
            ar[i] = a[n-i-1];
        }
        b = br.readLine().toCharArray();
        m = b.length;
        // left and right are points for given text
        int left = 0;
        int right = m-1;
        int where = 0;
        while (left <= right) {
            if (where == 0) {
                l[ln++] = b[left++];
            } else {
                r[rn++] = b[right--];
            }
            if (check(where)) {
                where = 1-where;
            }
        }
        for (int i=ln-1; i>=0; i--) {
            r[rn++] = l[i];
            check(1);
        }
        for (int i=rn-1; i>=0; i--){
            bw.write(r[i]);
        }
        bw.flush();
        bw.close();
    }
}