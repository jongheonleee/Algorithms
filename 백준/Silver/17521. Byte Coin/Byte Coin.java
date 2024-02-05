import java.util.*;
import java.io.*;

public class Main {

    private static int n, m;
    private static long ans;
    private static int[] price;

    // 1. 브루트 포스 선택 관점
    private static void go(int i, long cash, long coin) {
        // 종료 조건
        if (i == n) {
            long totalPrice = cash + coin * price[i-1];
            if (ans < totalPrice) ans = totalPrice;
            return;
        }

        // 진행

        // 건너뜀
        go(i+1, cash, coin);
        // 매수
        go(i+1, cash%price[i], coin+cash/price[i]);
        // 매도
        go(i+1, cash+coin*price[i], 0);

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
            // 0-0. n, m 입력 받기 및 ans = -1 초기화
            // 0-1. 그래프 테이블 형식으로 기록
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        ans = -1;

        price = new int[n];
        for (int i=0; i<n; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        // 1. 선택 관점 브루트 포스(재귀)
            // 1-0. 매수, 매도, 건너뜀
        go(0, m, 0);

        // 2. 최대값 출력
        System.out.println(ans);

   }
}
