import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;


/**
문제 요약
 - n마리 소 중 m선정, 그때의 합이 소수
 - 해당 소수의 총합
 */
public class Main {

    static int n, m, ans;
    static int[] weight;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 0. 세팅
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        ans = 0;
        set = new LinkedHashSet<>();
        weight = new int[n];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            weight[i] = Integer.parseInt(line[i]);
        }
        // 1. 소를 선택하는 모든 경우 따지기
        for (int k=0; k<(1<<n); k++) {
            // 소 선택하고 그때의 합 구하기
            int sum = 0, cnt = 0;
            for (int i=0; i<n; i++) {
                if ((k & (1<<i)) != 0) {
                    sum += weight[i];
                    cnt += 1;
                }
            }

            // 소수인지 판단
            if (cnt == m) {
                boolean ok = true;
                for (int i=2; i<=Math.sqrt(sum); i++) {
                    if (sum % i == 0) {
                        ok = false;
                    }
                }

                if (ok) {
                    set.add(sum);
                }
            }
        }

        // 결과 출력
        if (set.size() == 0) {
            System.out.println(-1);
        } else {
            set.stream().sorted().forEach((i) -> System.out.print(i + " "));
        }

    }
}

