import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static boolean next_permutation(int[] a) {
        // 1. 최대 길이의 마지막 부분 수열을 찾음
        int i = a.length-1;
        while (i>0 && a[i-1] >= a[i]) {
            i--;
        }

        if (i<=0) {
            return false;
        }

        // 2. a[i-1]와 a[j] 스왑
        // 이때, a[j] >= a[i-1]을 만족하는 가장 큰 j
        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j--;
        }
        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        // 3. 마지막 수열 부분을 첫 수열 부분으로, 즉 내림차순을 뒤집어서 오름차순으로 만들기
        j = a.length-1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;
            i++; j--;
        }
        return true;

    }


    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] w = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        int ans = Integer.MAX_VALUE;
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = i;
        }

        do {
            boolean ok = true;
            int sum = 0;
            for (int i=0; i<n-1; i++) {
                if (w[a[i]][a[i+1]] == 0) {
                    ok = false;
                } else {
                    sum += w[a[i]][a[i+1]];
                }
            }
            if (ok && w[a[n-1]][a[0]] != 0) {
                sum += w[a[n-1]][a[0]];
                if (ans > sum) ans = sum;
            }
        } while (next_permutation(a));
        System.out.println(ans);

    }
}