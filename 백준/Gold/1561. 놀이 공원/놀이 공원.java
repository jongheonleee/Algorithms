import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        long left = 0;
        long right = 2000000000L * 1000000L;
        while (left <= right) {
            long mid = (left + right) / 2;
            long begin, end;
            begin = end = 0;
            end = n;
            for (int i=0; i<n; i++) {
                end += mid/a[i];
            }
            begin = end;
            for (int i=0; i<n; i++) {
                if (mid % a[i] == 0) {
                    begin -= 1;
                }
            }
            begin += 1;
            if (p < begin) {
                right = mid-1;
            } else if (p > end) {
                left = mid+1;
            } else {
                for (int i=0; i<n; i++) {
                    if (mid % a[i] == 0) {
                        if (p == begin) {
                            System.out.println(i+1);
                            return;
                        }
                        begin += 1;
                    }
                }
            }
        }

    }
}