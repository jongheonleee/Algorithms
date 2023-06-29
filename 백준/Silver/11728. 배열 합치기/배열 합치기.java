import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] a = new int[n], b = new int[m], merge = new int[n+m];
        int i=0, j=0, k=0;

        String[] line1 = br.readLine().split(" ");
        for (int z=0; z<n; z++) {
            a[z] = Integer.parseInt(line1[z]);
        }

        String[] line2 = br.readLine().split(" ");
        for (int z=0; z<m; z++) {
            b[z] = Integer.parseInt(line2[z]);
        }

        // compare a[i] and b[j] then push small one in merge
        while (i < n && j < m && k < n+m) {
            if (a[i] >= b[j]) {
                merge[k++] = b[j++];
            }
            else {
                merge[k++] = a[i++];
            }
        }

        while (i < n && k < n+m) merge[k++] = a[i++];
        while (j < m && k < n+m) merge[k++] = b[j++];

        for (int z=0; z<n+m; z++) {
            sb.append(merge[z]).append(" ");
        }
        System.out.println(sb);
    }
}