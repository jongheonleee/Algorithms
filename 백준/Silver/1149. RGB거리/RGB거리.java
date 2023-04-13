import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[3][n+1];
        int[] a = new int[n+1];

        // dp 알고리즘 적용
        for (int i=1; i<=n; i++) {
            // a 배열 초기화 해주기
            st = new StringTokenizer(br.readLine(),  " ");
            for (int j=0; j<=2; j++) a[j] = Integer.parseInt(st.nextToken());

            d[0][i] = Math.min(d[1][i-1], d[2][i-1]) + a[0];
            d[1][i] = Math.min(d[0][i-1], d[2][i-1]) + a[1];
            d[2][i] = Math.min(d[0][i-1], d[1][i-1]) + a[2];
        }

        // 최소값 찾기
        int result = d[0][n];
        for (int i=1; i<=2; i++) 
            result = result > d[i][n] ? d[i][n] : result;
        
        System.out.println(result);
        
    }
}