import java.util.*;
import java.io.*;


public class Main {

    static int lower_bound(int[] d, int n, int key) {
        int left = 0, right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (d[mid] >= key) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];

        int len = 0;
        for (int i=0; i<n; i++) {
            int num = sc.nextInt();
            int idx = lower_bound(d, len, num);
            if (d[idx] == 0) {
                d[idx] = num;
                len++;
            } else {
                d[idx] = num;
            }
        }

        System.out.println(len);


    }
}