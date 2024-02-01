import java.util.*;
import java.io.*;


public class Main {

    private static List<Integer> list = new ArrayList<>();

    // 종말 수 판별
    private static boolean check(int num) {
        list.clear();
        while (num > 0) {
            int r = num%10;
            list.add(r);
            num /= 10;
        }

        for (int i=0; i<=list.size()-3; i++) {
            if (list.get(i) == 6 && list.get(i) == list.get(i+1) && list.get(i+1) == list.get(i+2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
        int n = Integer.parseInt(br.readLine());
        int count = 0, ans = 0;

        // 1. 반복문 돌리기
            // 1-0. 종말수 확인
            // 1-1. 맞으면 count+1
            // 1-2. count == n이면 해당 값 출력
        for (int i=0; i<=200_000_000; i++) {
            if (check(i)) {
                count++;
                if (n == count) {
                    ans = i;
                    break;
                }
            }
        }

        System.out.println(ans);

   }
}
