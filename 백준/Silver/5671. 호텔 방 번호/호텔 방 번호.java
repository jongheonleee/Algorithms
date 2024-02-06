import java.util.*;
import java.io.*;

public class Main {

    private static int[] counter = new int[10];

    private static void initCounter() {
        for (int i=0; i<10; i++) counter[i] = 0;
    }

    private static boolean isValidNumber(int number) {
        initCounter();
        while (number > 0) {
            int r = number % 10;
            number = number / 10;
            counter[r] += 1;
        }

        for (int i=0; i<10; i++) {
            if (counter[i] > 1) return false;
        }

        return true;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 0. 세팅
            // 0-0. 전체 범위 만큼 배열 선언
            // 0-1. 문제의 조건을 만족하는 숫자 체크
        boolean[] isRoomNumber = new boolean[50000+1];

        for (int i=1; i<isRoomNumber.length; i++) {
            if (isValidNumber(i)) {
                isRoomNumber[i] = true;
            }
        }


        // 1. n, m 범위 내에 문제 조건을 만족하는 숫자 개수 카운트
            // 1-0. n, m 입력 받기
            // 1-1. 해당 범위내에 문제 조건을 만족하는 숫자 카운트
            // 1-2. 결과 스트링 빌더에 기록
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int cnt = 0;

            for (int i=n; i<=m; i++) {
                if (isRoomNumber[i]) cnt++;
            }

            System.out.println(cnt);
        }
        

   }
}