import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
문제 요약

 정수 A를 B로 변환,  2가지 연산
 - 1. 2 곱함
 - 2. 1 붙임

 */

public class Main {

    /**
     접근법

     */


    private static int ans = -1;
    private static void go(long curr, long dest, int count) {
        if (curr > dest) {
            return;
        }
        
        if (curr == dest) {
            if (ans == -1 || ans > count+1) ans = count+1;
            return;
        }

        go(curr*2, dest, count+1);
        go(curr*10+1, dest, count+1);
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 입력 받기
        String[] line = br.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        if (a == b) {
            System.out.println(1);
            System.exit(0);
        }
        // 재귀호출
        go(a, b, 0);
        // 결과 출략
        System.out.println(ans);
    }
}

