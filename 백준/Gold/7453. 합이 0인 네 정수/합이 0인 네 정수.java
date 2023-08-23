import java.util.*;
import java.io.*;


public class Main {

    static int upper_bound(int[] a, int val) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = (left+right)/2;

            if (a[mid] <= val) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int lower_bound(int[] a, int val) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = (left+right)/2;

            if (a[mid] >= val) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];


        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            a[i] = Integer.parseInt(line[0]);
            b[i] = Integer.parseInt(line[1]);
            c[i] = Integer.parseInt(line[2]);
            d[i] = Integer.parseInt(line[3]);
        }

        int[] first = new int[n*n];
        int[] second = new int[n*n];
        int idx = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                first[idx] = a[i] + b[j];
                second[idx] = c[i] + d[j];
                idx += 1;
            }
        }
        Arrays.sort(second);
        long ans = 0;

        for (int s : first) {
            int target = -s;
            int lower = lower_bound(second, target);
            int upper = upper_bound(second, target);
            ans += upper - lower;
        }

        System.out.println(ans);


    }
}