import java.util.*;
import java.io.*;
class Pair {
    int min;
    int max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class Main {

    static int[] a;
    static Pair go(int i, int cur, int plus, int minus, int mul, int div) {
        int n = a.length;

        if (i == n) {
            return new Pair(cur, cur);
        }

        ArrayList<Pair> result = new ArrayList<>();
        if (plus > 0) {
            result.add(go(i+1, cur+a[i],plus-1, minus, mul, div));
        }

        if (minus > 0) {
            result.add(go(i+1, cur-a[i], plus, minus-1, mul, div));
        }

        if (mul > 0) {
            result.add(go(i+1, cur*a[i], plus, minus, mul-1, div));
        }

        if (div > 0) {
            result.add(go(i+1, cur/a[i], plus, minus, mul, div-1));
        }

        Pair ans = result.get(0);

        for (Pair p : result) {
            if (ans.min > p.min) {
                ans.min = p.min;
            }

            if (ans.max < p.max) {
                ans.max = p.max;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        Pair ans = go(1, a[0], plus, minus, mul, div);

        System.out.println(ans.max);
        System.out.println(ans.min);

    }
}