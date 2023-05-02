import java.util.*;
import java.io.*;
public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int[] d1 = new int[n], d2 = new int[n];

        for (int i=0; i<n; i++) {
            d1[i] = 1;
            for (int j=0; j<i; j++) {
                if (a[j] < a[i]) {
                    d1[i] = d1[i] > 1 + d1[j] ? d1[i] : 1 + d1[j];
                }
            }
        }

        for (int i=n-1; i>-1; i--) {
            d2[i] = 1;
            for (int j=n-1; j>i; j--) {
                if (a[j] < a[i]) {
                    d2[i] = d2[i] > 1 + d2[j] ? d2[i] : 1 + d2[j];
                }
            }
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            result = result > d1[i] + d2[i] -1 ? result : d1[i] + d2[i] -1;
        }

        System.out.println(result);
        
    }
}