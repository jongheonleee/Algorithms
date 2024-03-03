import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


/**
문제 요약

 제한시간 1초, n = 10,000 -> O(N^2)

 PT를 받을 때마다 이전에 사용하지 않았던 운동기구를 선택하기로 계획, 2개씩 사용
 PT를 한 번 받을 때의 근손실 정도가 M을 넘지 않도록 하고 싶음
 M의 최솟값을 구해라

 */

public class Main {

    /**
     접근법

     그리디
     둘의 합을 작게 만들어야함
     작은거 + 큰거, 하지만 기구가 홀수개 일때 마지막에 하나 선택하는 경우도 고려

     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 입력받기
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        Long[] weight = new Long[n];
        for (int i=0; i<n; i++) {
            weight[i] = Long.parseLong(line[i]);
        }
        Arrays.sort(weight);
        long m = 0;
        // 작은거 + 큰거
        // 홀수개이면 마지막에 하나 빼고, 나머지 것들을 작은거 + 큰거로 구성
        if (n%2 == 1) {
            m = weight[n-1];
            for (int i=0; i<(n-1)/2; i++) {
                m = Math.max(m, weight[i] + weight[n-2-i]);
            }
        } else {
            for (int i=0; i<n/2; i++) {
                m = Math.max(m, weight[i] + weight[n-1-i]);
            }
        }

        // 결과 출력
        System.out.println(m);


    }
}
