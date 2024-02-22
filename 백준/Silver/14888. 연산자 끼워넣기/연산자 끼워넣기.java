import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;



/**
문제 요약

 N개의 수와 N-1개의 연산자가 주어졌을 때,
 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구해라
 2 ≤ N ≤ 11




 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다.
 나눗셈으로 몫만 취함
 음수를 양수로 나눌 때,  양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꿈

 0 : +, 1 : -, 2 : *, 3 : /

 */
public class Main {

    /** 접근법

     주어진 연산으로 모든 조합 형성
        연산자 우선순위 x 그대로 계산
        조건대로 계산

     계산하는 부분 스위치문으로 따로 메서드 분리

     브루트포스로 만들 수 있는 연산자 조합
     그때 값 계산
     최대 최소 업데이트

     > 0. 다음순열
     > 1. 문제조건에 맞는 계산 방법

     */
    static int n, min, max;
    static int[] numbers;
    static int[] com;
    static int[] count;

    static void calculate() {
        int res = numbers[0];
        for (int i=1; i<n; i++) {
            switch (com[i-1]) {
                case 0 : {
                    res += numbers[i];
                    break;
                }

                case 1 : {
                    res -= numbers[i];
                    break;
                }

                case 2 : {
                    res *= numbers[i];
                    break;
                }

                case 3 : {
                    if (res < 0) {
                        res *= -1;
                        int r = res/numbers[i];
                        res = r * (-1);
                    } else {
                        res /= numbers[i];
                    }
                    break;
                }
            }
        }

        max = Math.max(res, max);
        min = Math.min(res, min);
    }

    static void go(int depth) {
        if (depth == n-1) {
            calculate();
            return;
        }

        for (int i=0; i<4; i++) {
            if (count[i] == 0) continue;
            count[i] -= 1;
            com[depth] = i;
            go(depth+1);
            com[depth] = -1;
            count[i] += 1;
        }
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 입력받기
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        com = new int[n-1];

        String[] line1 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(line1[i]);
        }

        String[] line2 = br.readLine().split(" ");
        count = new int[4];

        for (int i=0; i<4; i++) {
            count[i] = Integer.parseInt(line2[i]);
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        // 브루트포스 돌리기
        go(0);

        // 출력
        System.out.println(max);
        System.out.println(min);
    }
}

