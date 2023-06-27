import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int IMPOSSIBLE = -1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]), k = Integer.parseInt(line[2]);

        if (m+k-1 <= n && n <= m*k) {
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = i+1;
            }

            ArrayList<Integer> groups = new ArrayList<>();

            groups.add(0); groups.add(k);
            n -= k; m -= 1;

            int groupSize = m == 0 ? 1 : n/m;
            int r = m == 0 ? 0 : n%m;

            for (int i=0; i<m; i++) {
                groups.add(groups.get(groups.size()-1) + groupSize + (r > 0 ? 1 : 0));

                if (r > 0) r--;
            }

            for (int i=0; i<groups.size()-1; i++) {
                int begin = groups.get(i), end = groups.get(i+1)-1;

                while (begin < end) {
                    int tmp = a[begin];
                    a[begin] = a[end];
                    a[end] = tmp;

                    begin++; end--;
                }
            }

            for (int i=0; i<a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        else {
            System.out.println(IMPOSSIBLE);
        }
    }
}