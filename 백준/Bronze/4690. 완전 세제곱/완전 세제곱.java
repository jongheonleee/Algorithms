import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

    // 0. 세팅
        // 0-1. 출력 기능 메서드 정의
        // 0-2. StringBuilder
    private static String format = "Cube = %d, Triple = (%d,%d,%d)\n";
    private static StringBuilder sb = new StringBuilder();
    private static void generateMessage(int a, int b, int c, int d) {
        String message = String.format(format, a, b, c, d);
        sb.append(message);
    }

    public static void main(String args[]) throws IOException {

        // 1. for 문 작성
            // 1-1. 1 a -> 1~100, b -> 1~a, c -> b~a, d -> c~a
            // 1-2. a^3 = b^3 + c^3 + d^3 만족하는 쌍 구하기
            // 1-3. (a, b, c, d) 출력 메서드로 넘기기
        for (int a=2; a<=100; a++) {
            for (int b=2; b<=a; b++) {
                for (int c=b; c<=a; c++) {
                    for (int d=c; d<=a; d++) {
                        if (a*a*a == b*b*b + c*c*c + d*d*d) {
                            generateMessage(a, b, c, d);
                        }
                    }
                }
            }
        }


        // 2. 출력
        System.out.println(sb);

    }
}
