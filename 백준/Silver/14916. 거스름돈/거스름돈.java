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

 2, 5 무한대
 동전의 개수 최소
 거스름돈 n


 */
public class Main {

    /** 접근법
     *  - 5원으로 n 나누고
     *  - 2원으로 나머지 나누기
     *  - 만약 1원이 남으면 -1 출력
    **/
    static int n, ans;

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 입력받기
        n = Integer.parseInt(br.readLine());
        ans = -1;
        for (int m1 = n/5; m1 >= 0; m1--) {
            int r1 = n - 5*m1;
            int m2 = r1/2;
            int r2 = r1 - 2*m2;
            if (r2 == 0) {
                if (ans == -1) {
                    ans = m1 + m2;
                } else if (ans > m1 + m2) {
                    ans = m1 + m2;
                }
            }
        }

        System.out.println(ans);
    }
}

