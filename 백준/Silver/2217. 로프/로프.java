import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;




/**
문제 요약

 N(1 ≤ N ≤ 100,000)개의 로프
 k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때,
 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸림
 임의로 몇 개의 로프를 골라서 사용
 물체의 최대 중량구하기(10,000 이하)

 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        int ans = a[n-1];
        for (int i=n-1; i>=0; i--) {
            ans = Math.max(ans, a[i] * (n - i));
        }

        System.out.println(ans);
    }
}
