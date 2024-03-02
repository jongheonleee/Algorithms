import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


/**
문제 요약

 a의 양을 xa + (xb / 2)로 만들고, b를 버리기
 b의 양을 xb + (xa / 2)로 만들고, a를 버리기
 합쳐진 에너지 드링크의 양을 최대
 (2 ≤ N ≤ 10^5, 1 ≤ xi ≤ 10^9)

 */

public class Main {

    /**
     접근법

     그리디
     양이 많은 쪽을 항상 선택하고 적은 쪽을 부어주기

     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 입력받기
        int n = Integer.parseInt(br.readLine());
        double totalCapacity = 0;
        String[] line = br.readLine().split(" ");
        Double[] capacity = new Double[n];
        for (int i=0; i<n; i++) {
            capacity[i] = Double.parseDouble(line[i]);
        }
        Arrays.sort(capacity, Collections.reverseOrder());

        // 그리디 적용
        // 양이 많은 쪽에 적은 쪽을 부어주기
        // 내림차순 정렬
        totalCapacity = (capacity[0]);
        for (int i=1; i<n; i++) {
            totalCapacity += (capacity[i]/2);
        }

        // 결과 출력하기
        System.out.println(totalCapacity);

    }
}
