import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
문제 요약

 각 손님은 강호에게 원래 주려고 생각했던 돈 - (받은 등수 - 1) 만큼의 팁을 강호에게 줌
 음수라면, 강호는 팁을 받을 수 없음
 손님 n명,손님의 순서를 적절히 바꿨을 때, 팁의 최댓값
 1 <= n <= 100_000


 */
public class Main {

    /**
     접근법

     cost - (받은 등수 - 1)
     cost가 가장 커지는게 좋음
     즉, 원래 주려는 팁의 값이 큰 손님부터 차례로 주는게 최대값을받음

     > 그리디 : 팁의 금액이 가장 큰 손님부터 차례로 준다

     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        // 0. 입력값 받기
        int n = Integer.parseInt(br.readLine());
        Integer[] cost = new Integer[n];

        for (int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }


        // 1. 내림차순 정렬
        Arrays.sort(cost, Collections.reverseOrder());

        // 2. 차례로 커피 전달하고 팁 값 계산
        long totalCost = 0;
        for (int i=0; i<n; i++) {
            if (cost[i] <= i) {
                break;
            }
            totalCost += cost[i] - i;
        }

        // 3. 결과 출력
        System.out.println(totalCost);
    }
}
