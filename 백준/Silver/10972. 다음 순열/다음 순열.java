import java.io.*;
import java.util.*;
public class Main {
    

    public static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i>0 && a[i-1] >= a[i]) i--;

        if (i <= 0) return false;

        int j = a.length-1;
        while (a[i-1] >= a[j]) j--;

        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        j = a.length-1;
        while(i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;
            i++; j--;
        }

        return true;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        if (next_permutation(a)) {
            for (int i=0; i<n; i++) {
                sb.append(a[i]).append(" ");
            }
            System.out.println(sb);
        }else {
            System.out.println(-1);
        }
    }
}