import java.util.*;
import java.io.*;
public class Main {
    static final int COUNT = 6;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> lotto = new ArrayList<>();
    static void go(int[] a, int idx, int cnt) {
        if (cnt == COUNT) {
            for (int n : lotto) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int n = a.length;
        if (n == idx) return;

        lotto.add(a[idx]);
        go(a, idx+1, cnt+1);
        lotto.remove(lotto.size()-1);
        go(a, idx+1, cnt);

    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int[] a = new int[k];
            for (int i=0; i<k; i++) {
                a[i] = sc.nextInt();
            }

            go(a, 0, 0);
            sb.append("\n");
        }

        System.out.println(sb);

    }
}