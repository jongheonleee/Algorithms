import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;


/**
문제 요약

 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

 */

public class Main {

    /**
     접근법

     > 그리디, - 가 관건

     1. -가 나오면 다음 -가 나오기 전까지 해당 범위 () 처리
        ()처리용 체킹이 필요

     2. 전체합, 부분합, 숫자 기록용 변수 선언

     */


    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        String line = br.readLine();
        int totalSum = 0, partSum = 0, number = 0;
        boolean check = false;

        for (char ch : line.toCharArray()) {
            // +
            if (ch == '+') {
                if (check) {
                    partSum += number;
                } else {
                    totalSum += number;
                }
                number = 0;
            }
            // -
            else if (ch == '-') {
                if (check) {
                    partSum += number;
                    totalSum -= partSum;
                } else {
                    check = true;
                    totalSum += number;
                }
                partSum = 0;
                number = 0;
            }
            // 숫자
            else {
                number = number * 10 + (ch-'0');
            }
        }

        if (number > 0) {
            if (check) {
                partSum += number;
            } else {
                totalSum += number;
            }
        }
        
        if (partSum > 0) {
            totalSum -= partSum;
        }
        
        System.out.println(totalSum);
    }
}
