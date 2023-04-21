import java.io.*;

public class Main {

    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         *      초기화 단계
         *      - N : 입력값 정수(카드의 개수)
         *      - priceStr : 카드팩[i]의 가격을 문자열 배열로 저장(i는 카드의 개수)
         *      - price <- priceStr : 문자열 배열을 정수 배열로 변환
         */
        int N = Integer.parseInt(br.readLine());
        String[] priceStr = br.readLine().split(" ");
        int[] price = new int[N+1];

        for (int i=0; i<N; i++) {
            price[i+1] = Integer.parseInt(priceStr[i]);
        }

        /**
         *      알고리즘 구현
         *      - dp 적용
         *      - 점화식 : dp[N] = max(dp[N-i] + price[i])
         *      - dp[N] : 민규가 돈을 최대한 많이 지불해서 카드 N개를 구매한 가격
         *      - bottom-up 형식으로 구현
         */

        dp = new int[N+1];

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j]+price[j]);
            }
        }

        System.out.println(dp[N]);
    }

}