import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         *      초기화 단계
         *
         *      n : 수열의 길이 (1 <= n <= 100,000)
         *      a : 수열 (-1,000 <= a[i] <= 1,000)
         *      d : a[i]를 기준으로 연속된 몇 개의 수를 선택해서 구할 수 있는 최대합 저장
         *
         */
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d = new int [n];

        // a 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = a[i];
        }

        /**
         *      알고리즘 구현
         *
         *      dp 점화식 : d[i] = max(d[i], d[i-1] + a[i])
         *
         */

        d[0] = a[0];
        for (int i=1; i<n; i++) {
            if (d[i] < d[i-1]+a[i]) {
                d[i] = d[i-1]+a[i];
            }
        }

        int result = d[0];
        for (int i=1; i<n; i++) {
            if (result < d[i]) {
                result = d[i];
            }
        }

        System.out.println(result);
    }
}