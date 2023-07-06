import java.util.*;
import java.io.*;


public class Main {

    private static int[] merge(int[] a, int[] b) {
        int l = 0, r = 0, k = 0;
        int[] res = new int[a.length + b.length];

        while (l < a.length && r < b.length) {
            if (a[l] <= b[r]) {
                res[k++] = a[l++];
            }
            else {
                res[k++] = b[r++];
            }
        }

        while (l < a.length) res[k++] = a[l++];
        while (r < b.length) res[k++] = b[r++];

        return res;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int[] a = new int[n];
        int[] b = new int[m];

        String[] line1 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line1[i]);
        }
        String[] line2 = br.readLine().split(" ");
        for (int j=0; j<m; j++) {
            b[j] = Integer.parseInt(line2[j]);
        }

        int[] res = merge(a, b);
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);


    }
}