import java.util.*;
import java.io.*;

/**문제 요약
 *
 * 1부터 N까지의 숫자 카드, 1 맨위 n 맨 아래
 * (2, K) - 섞기는 총 K + 1개의 단계
 * 쳐음 : 2K 개의 카드를 더미의 맨 위, 그 이후 : 직전에 맨 위로 올린 카드 중 밑에서 2K - i + 1개의 카드를 더미의 맨 위로 올림
 *
 */
public class Main {

    static int n, x, y;
    static int[] answer;
    static int[] generate;


    static void simulate(int k1, int k2) {
        // 반복작업 처리
        go(1, k1, n);
        go(1, k2, n);
    }

    // 카드 더미 올리는 작업 반복
    static void go(int i, int k, int range) {
        // 종료
            // i가 k+2에 도달
        if (i == k+2) return;


        // 진행 과정
        int cnt = (int)Math.pow(2, k-i+1);
        if (range - cnt > 0) {
            mix(range, cnt);
            go(i+1, k, cnt);
        }

    }

    static void mix(int range, int cnt) {
        int[] tmp = new int[1000];
        int idx = 0;

        for (int i=range-cnt; i<range; i++) {
            tmp[idx++] = generate[i];
            generate[i] = 0;
        }

        for (int i=0; i<n; i++) {
            if (generate[i] != 0) {
                tmp[idx++] = generate[i];
            }
            generate[i] = tmp[i];
        }
    }

    static boolean compare() {
        for (int i=0; i<n; i++) {
            if (answer[i] != generate[i]) return false;
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
            // 0-0. n 입력받기( 3 <= n <= 1,000)
            // 0-1. 주어진 카드 덱 정보 기록
            // 0-2. 첫번째 두번째 k 정보 기록할 변수 선언 (1 <= k < 10)
        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        answer = new int[n];
        generate = new int[n];

        for (int i=0; i<n; i++) {
            answer[i] = Integer.parseInt(line[i]);
            generate[i] = Integer.parseInt(line[i]);
        }

        // 1. 첫번째, 두번째  k 선정
            // 1-0. 시뮬레이션 돌리기
                // 1-0-0. 재귀로 구현, 2^k -> 2 ^ (k-2+1) -> 2 ^ (k-3+1) ... -> 2 ^ (k-i+1) ( 2 <= i <= k+1)

            // 1-1. 주어진 결과와 비교
                // 1-1-0. 맞으면, 해당 값 기록하고 출력
        for (int k1=1; Math.pow(2, k1) <= n; k1++) {
            for (int k2=1; Math.pow(2, k2) <= n; k2++) {
                for (int i=0; i<n; i++) {
                    generate[i] = i+1;
                }
                simulate(k1, k2);
                if (compare()) {
                    System.out.println(k1 + " " + k2);
                    return;
                }
            }
        }

        System.out.println(x + " " + y);

   }
}
