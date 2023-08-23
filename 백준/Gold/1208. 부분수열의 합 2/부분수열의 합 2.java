import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int m = n/2;
        n = n-m;

        int[] first = new int[1<<n];
        int[] second = new int[1<<m];

        for (int i=0; i<(1<<n); i++) {
            for (int k=0; k<n; k++) {
                if ((i & (1<<k)) != 0) {
                    first[i] += a[k];
                }
            }
        }

        for (int j=0; j<(1<<m); j++) {
            for (int k=0; k<m; k++) {
                if ((j & (1<<k)) != 0) {
                    second[j] += a[k+n];
                }
            }
        }


        Arrays.sort(first);
        Arrays.sort(second);

        n = (1<<n);
        m = (1<<m);

        for (int i=0; i<m/2; i++) {
            int tmp = second[i];
            second[i] = second[m-i-1];
            second[m-i-1] = tmp;
        }

        int i = 0, j = 0;
        long ans = 0;

        while (i < n && j < m) {
            int sum = first[i] + second[j];

            if (sum == s) {
                long c1 = 1;
                long c2 = 1;
                i += 1;
                j += 1;

                while (i < n && first[i-1] == first[i]) {
                    i += 1;
                    c1 += 1;
                }

                while (j < m && second[j-1] == second[j]) {
                    j += 1;
                    c2 += 1;
                }

                ans += c1 * c2;
            } else if (sum < s) {
                i += 1;
            } else {
                j += 1;
            }
        }

        if (s == 0) ans -= 1;

        System.out.println(ans);


    }
}