import java.io.*;
import java.util.*;



public class Main {

    static int b;
    static int power10(int k) {
        int n = 1;

        for (int i=0; i<k; i++) {
            n *= 10;
        }

        return n;
    }

    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) i--;

        if (i<=0) return false;

        int j = a.length-1;
        while (a[j] <= a[i-1]) j --;

        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        j = a.length-1;
        while (i<j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++; j--;
        }

        return true;
    }

    static int arrToInt(int[] a) {
        int n = 0;

        for (int i=0; i<a.length; i++) {
            n = n*10 + a[i];
        }

        return n;
    }



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        String aStr = line[0];
        b = Integer.parseInt(line[1]);

        int[] a = new int[aStr.length()];
        for (int i=0; i<aStr.length(); i++) {
            int num = aStr.charAt(i) - '0';
            a[i] = num;
        }
        Arrays.sort(a);

        int ans = -1;
        do {
            int c = arrToInt(a);
            if (power10(a.length-1) < c && c < b) ans = c;
        } while (next_permutation(a));

        System.out.println(ans);
    }
}