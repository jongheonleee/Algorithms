import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int ans = -1;
        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }
        for (int d1=-1; d1<=1; d1++) {
            for (int d2=-1; d2<=1; d2++) {
                int a0 = a[0]+d1;
                int a1 = a[1]+d2;

                int cnt = 0;
                if (d1 != 0) cnt++;
                if (d2 != 0) cnt++;

                boolean ok = true;
                int d = a1-a0;

                a0 = a1;
                for (int i=2; i<n; i++) {
                    a1 = a[i];

                    int diff = a1-a0;
                    if (diff == d) {
                        a0 = a1;
                        continue;
                    } else if (diff+1 == d) {
                        cnt++;
                        a1++;
                        a0 = a1;
                    } else if (diff-1 == d) {
                        cnt++;
                        a1--;
                        a0 = a1;
                    } else {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    if (ans == -1 || ans > cnt) ans = cnt;
                }
            }
        }
        System.out.println(ans);

    }
}