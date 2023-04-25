import java.io.*;
import java.util.*;
public class Main {

    public static boolean next_permutation(int[] a) {
        // 1. a[i-1] < a[i]를 만족하는 가장 큰 i 찾기(내림차순이 깨지는 구간)
        // 계산의 편의를 위해 뒤에서 부터 탐색
        int i = a.length-1;
        while (i>0 && a[i-1] >= a[i]) {
            i--;
        }
        // 예외처리, 입력 받은 수열이
        if (i <= 0)
            return false;

        // (2) j >= i이면, a[j] > a[i-1]을 만족하는 가장 큰 j 찾기
        int j = a.length-1;
        while (a[j] <= a[i-1]){
            j--;
        }

        // (3) a[i-1]과 a[i]를 swap
        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        // (4) a[i]부터 수열 뒤집기
        // 해당 부분 수열을 첫 수열 형태로 바꿔줘야 함
        j = a.length-1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;
            i += 1; j -= 1;
        }

        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        if (next_permutation(a)) {
            for (int i=0; i<n; i++) {
                sb.append(a[i] + " ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }


    }
}
