import java.util.*;
import java.io.*;

/**
 * 문제가 5지 선다의 객관식 10문제
 * 3개의 연속된 문제의 답은 같지 않게 한다
 * 점수가 5점 이상일 경우의 수(1문제당 1점씩)
 */
public class Main {
    static int[] answer = new int[10];
    static int[] random = new int[10];
    static int count = 0;


    // 1. 모든 경우의 수 따지기(브루트 포스 재귀적 구현)
        // 브루트 포스 활용, i : 문제 번호(0~9)
        // 1-0. 특정 문제 번호에서 1~5 중 하나 선택
        // 1-1. 찍는 방법 배열에 기록
        // 1-2. 위 과정을 i가 10이 될 때까지 진행
            // 1-2-0. 3개 연속으로 같은 답을 찍엇는지 확인
                // 1-2-0-0. 중단
                // 1-2-0-1. 맞은 개수 확인
                    // 1-2-0-1-0. 5개 이상 맞았으면 카운트
    static void go(int i) {
        // 종료 조건 : i = 10
            // 3개 연속 -> 종료
            // 3개 연속 x -> 5개 이상 맞음 -> 카운트
        if (i == 10) {
            if (isValid()) {
                count();
            }
            return;
        }
        // 진행 과정
            // 5개 중에 한개 선택하기(1~5)
        for (int j=1; j<=5; j++) {
            random[i] = j;
            go(i+1);
            random[i] = 0;
        }
    }

    // 5개 이상 맞았으면 카운트
    static void count() {
        int k = 0;
        for (int i=0; i<10; i++) {
            if (answer[i] == random[i]) k++;
        }

        if (k >= 5) count++;
    }

    // 3번 연속으로 같은 번호 찍었는지 확인
    static boolean isValid() {
        for (int i=0; i<=10-3; i++) {
            if (random[i] == random[i+1] && random[i+1] == random[i+2]) return false;
        }
        return true;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
            // 0-0. 정답지 배열로 기록 ->  cv
            // 0-1. 앞으로 만들어갈 찍는 방법 배열로 기록 -> cv
            // 0-2. 5점 이상인 경우 카운트, count -> cv
        String[] line = br.readLine().split(" ");
        for (int i=0; i<10; i++) {
            answer[i] = Integer.parseInt(line[i]);
        }

        // 1. 모든 경우 따지기(브루트 포스)
        go(0);

        // 2. 결과 출력
        System.out.println(count);

   }
}

