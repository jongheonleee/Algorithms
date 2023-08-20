import java.util.*;
import java.io.*;


public class Main {

    static final int n = 3;

    public static boolean next_permutation(int[] a) {
        // (1) "a[i-1] < a[i]를 만족하는 가장 큰 i 찾기"
        // a는 수열을 의미함, 즉 i는 현재 a의 마지막 인덱스를 의미함
        int i = a.length-1;
        // 뒤에서부터(마지막 인덱스 부터)탐색하면서, 내림차순 영역을 구함('->' 방향기준)
        // i-1,i에서 내림차순 깨짐
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        // 예외처리 -> 마지막 수열(해당 순열이 처음부터 끝까지 내림차순으로 나열된 형태)
        if (i <= 0) {
            return false;
        }

        // (2) j>=i이면, a[j] > a[i-1]을 만족하는 가장 큰 j 찾기
        // j는 a의 마지막 인덱스를 의미함
        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        // (3) a[i-1] 과 a[i]를 swap
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        // (4) a[i]부터 수열을 뒤집기 (내림차순 -> 오름차순)
        // 동작 원리가 첫번째와 마지막꺼를 스왑해주면서 내림차순을 오름차순으로 바꿔주는 형태
        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    static boolean validate(int[] b) {
        int check = b[n*0+0] + b[n*0+1] + b[n*0+2];

        // 가로줄
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                sum += b[n*i+j];
            }

            if (check !=  sum) return false;
        }

        // 세로줄
        for (int j=0; j<n; j++) {
            int sum = 0;
            for (int i=0; i<n; i++) {
                sum += b[n*i+j];
            }

            if (check != sum) return false;
        }

        // 대각선
        if (check != b[n*0+0] + b[n*1+1] + b[n*2+2]) return false;
        if (check != b[n*2+0] + b[n*1+1] + b[n*0+2]) return false;

        return true;
    }

    static int cost(int[] a, int[] b) {
        int cost = 0;

        for (int i=0; i<n*n; i++) {
            if (a[i] != b[i]) cost += Math.abs(a[i] - b[i]);
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[n*n];
        int[] b = new int[n*n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i*n+j] = sc.nextInt();
            }
        }

        for (int i=1; i<=n*n; i++) b[i-1] = i;

        int ans = -1;
        do {
            if (validate(b)) {
                int cost = cost(a, b);
                if (ans == -1 || ans > cost) ans = cost;
            }
        } while (next_permutation(b));

        System.out.println(ans);


    }
}