import java.util.*;
import java.io.*;

class Pair {
    boolean ok;
    int cnt;

    Pair(boolean ok, int cnt) {
        this.ok = ok;
        this.cnt = cnt;
    }
}


public class Main {

    static final int IMPOSSIBLE = -1;

    static void change(int[] a, int idx) {
        for (int i=idx-1; i<=idx+1; i++) {
            if (0 <= i && i < a.length) {
                a[i] = 1 - a[i];
            }
        }
    }

    static Pair go(int[] a, int[] goal) {
        int cnt = 0;
        for (int i=0; i<a.length-1; i++) {
            if (a[i] != goal[i]) {
                cnt++;
                change(a, i+1);
            }
        }

        for (int i=0; i<a.length; i++) {
            if (a[i] != goal[i]) {
                return new Pair(false, cnt);
            }
        }

        return new Pair(true, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] goal = new int[n];

        String lineA = br.readLine();
        for (int i=0; i<n; i++) {
            a[i] = lineA.charAt(i)-'0';
        }

        String lineGoal = br.readLine();
        for (int i=0; i<n; i++) {
            goal[i] = lineGoal.charAt(i)-'0';
        }

        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        Pair first = go(a, goal);
        change(b, 0);
        Pair second = go(b, goal);
        if (second.ok) {
            second.cnt++;
        }

        if (first.ok && second.ok) {
            if (first.cnt <= second.cnt) {
                System.out.println(first.cnt);
            }
            else {
                System.out.println(second.cnt);
            }
        } else if (first.ok) {
            System.out.println(first.cnt);
        } else if (second.ok) {
            System.out.println(second.cnt);
        } else {
            System.out.println(IMPOSSIBLE);
        }

    }

}