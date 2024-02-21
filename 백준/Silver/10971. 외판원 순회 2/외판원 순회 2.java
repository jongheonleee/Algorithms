import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;



/**
문제 요약

 도시 1 ~ n, 특정 도시에서 시작해서 다 돌아보기, 중복방문 x, 최소 비용
 w[i][j] = i -> j 가는데 드는 비용
 w[i][j] = 0은 못감


 */
public class Main {

    /** 접근법

     다음순열로 도시 방문 경로 모두 구하기
     그때의 총 방문비용 구하고 최소값 업데이트

     */

    static int[] a = new int[10];
    static boolean next_permutation(int[] a, int n) {
        int i = n-1;
        while (i>0 && a[i-1] >= a[i]) i--;

        if (i <= 0) return false;

        int j = n-1;
        while (a[i-1] >= a[j]) j--;

        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        j = n-1;
        while(i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;
            i++; j--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int n = Integer.parseInt(br.readLine());
        int[][] w = new int[n][n];
        for (int i=0; i<n; i++) {
            a[i] = i;
        }

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                w[i][j] = Integer.parseInt(line[j]);
            }
        }

        int min = Integer.MAX_VALUE;
        do {
            boolean ok = true;
            int tmp = 0;
            for (int i=0; i<n-1; i++) {
                if (w[a[i]][a[i+1]] == 0) {
                    ok = false;
                } else {
                    tmp += w[a[i]][a[i+1]];
                }
            }

            if (ok && w[a[n-1]][a[0]] != 0) {
                tmp += w[a[n-1]][a[0]];
            } else {
                ok = false;
            }

            if (ok) {
                min = Math.min(min, tmp);
            }
        } while (next_permutation(a, n));
        System.out.println(min);

    }
}