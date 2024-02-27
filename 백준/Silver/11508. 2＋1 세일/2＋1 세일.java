import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
문제 요약

 유제품 3개를 한 번에 산다면 그중에서 가장 싼 것은 무료로 지불하고 나머지 두 개의 제품 가격만 지불
 최소비용으로 유제품을 구입
 N (1 ≤ N ≤ 100,000), Ci (1 ≤ Ci ≤ 100,000)
 */
public class Main {

    /**
     접근법

     그리디
     가장 큰거 3개씩 묶기
     그중 가장 작은거 지불 x

     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int n = Integer.parseInt(br.readLine());
        Integer[] cost = new Integer[n];

        for (int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cost, Collections.reverseOrder());
        int totalCost = 0, i = 0;
        while (i < n) {
            totalCost += (i+1)%3 == 0 ? 0 : cost[i];
            i++;
        }

        System.out.println(totalCost);
    }
}
