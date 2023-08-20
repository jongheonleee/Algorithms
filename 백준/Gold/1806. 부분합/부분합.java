import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0, right = 0, dist = 0, sum = a[0];
        
        if (a[n-1] >= m) {
            System.out.println(1);
            System.exit(0);
        }

        while (left <= right && right < n) {
            if (sum >= m) {
                if (dist == 0 || dist > (right - left+1)) {
                    dist = (right-left+1);
                }

                sum -= a[left];
                left += 1;

                if (left > right && left < n) {
                    right = left;
                    sum = a[right];
                }
            } else {
                if (right < n-1) {
                    right += 1;
                    sum += a[right];
                } else {
                    left = right;
                    right += 1;
                }
            }
        }

        System.out.println(dist);

    }
}