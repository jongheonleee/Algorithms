import java.util.*;
import java.io.*;
public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];

        // 예외 처리
        if (n<2 || n%2==1) {
            System.out.println(0);
            return;
        }

        // 기본 세팅 값
        d[2] = 3;
        // 누적합 계산
        int acc = 0;
        for (int i=4; i<=n; i+=2) {
            acc += d[i-4]*2;
            d[i] = d[i-2]*3 + 2 + acc;
        }

        System.out.println(d[n]);
    }
}