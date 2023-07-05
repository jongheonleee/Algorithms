import java.util.*;
import java.io.*;



// O(N * logN) 이하
public class Main {


    private static int lower_bound(int[] a, int t) {
        int left = 0, right = a.length-1, pos = 0;

        while (left <= right) {
            int mid = (left+right)/2;

            if (a[mid] == t) {
                pos = mid;
                right = mid - 1;
            } else if (a[mid] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return pos;
    }
    
    private static int upper_bound(int[] a, int t) {
        int left = 0, right = a.length-1, pos = 0;

        while (left <= right) {
            int mid = (left+right)/2;

            if (a[mid] == t) {
                left = mid + 1;
                pos = left;
            } else if (a[mid] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return pos;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line1 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line1[i]);
        }
        
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<m; i++) {
            b[i] = Integer.parseInt(line2[i]);
        }

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();


        for (int i=0; i<m; i++) {
            int p1 = lower_bound(a, b[i]);
            int p2 = upper_bound(a, b[i]);

            sb.append(p2-p1).append(" ");
        }

        System.out.println(sb);

    }
}