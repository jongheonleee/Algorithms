import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        
        // len 은 자릿수의 길이를 의미함, 예를 들어 10의 자리이면 len = 2
        for (int start=1, len=1; start<=n; start*=10, len++) {
            // 해당 자릿수의 마지막 수 구하기
            int end = start*10-1;
            // 마지막 수 > n 인 경우 end = n으로 해주기
            if (end > n) end = n;
            
            ans += (long)(end-start+1)*len;
        }

        System.out.println(ans);
    }
}