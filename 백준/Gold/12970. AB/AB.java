import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]), k = Integer.parseInt(line[1]);

        for (int a=0; a<n; a++) {
            int b = n-a;

            if (a*b < k) continue;

            int[] cnt = new int[b+1];
            for (int i=0; i<a; i++) {
                int x = Math.min(k, b);
                cnt[x] += 1;
                k -= x;
            }

            for (int i=b; i>=0; i--) {
                for (int j=cnt[i]; j>0; j--) {
                    System.out.print('A');
                }

                if (i > 0) {
                    System.out.print('B');
                }
            }
            System.out.println();
            System.exit(0);
        }
        System.out.println(-1);
    }
}