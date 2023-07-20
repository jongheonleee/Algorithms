import java.io.*;
import java.util.*;


public class Main {

    static final long MAX = 2_000_000_000 * 300_000L;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        String[] line = br.readLine().split(" ");
        int[] a = new int[m];
        for (int i=0; i<m; i++) {
            a[i] = Integer.parseInt(line[i]);
        }


        long left = 0, right = MAX;
        while (left <= right) {
            long mid = (left+right)/2;

            long begin = 0, end = m;
            for (int i=0; i<m; i++) {
                end += mid/a[i];
            }
            begin = end;
            for (int i=0; i<m; i++) {
                if (mid%a[i] == 0) {
                    begin--;
                }
            }
            begin++;

            if (begin > n) {
                right = mid-1;
            } else if (end < n) {
                left = mid+1;
            } else {
                for (int i=0; i<m; i++) {
                    if (mid%a[i] == 0) {
                        if (begin == n) {
                            System.out.println(i+1);
                            return;
                        }
                        begin++;
                    }
                }
            }
        }


    }
}