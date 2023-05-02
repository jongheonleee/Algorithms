import java.util.*;
import java.io.*;
public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), s = Integer.parseInt(line[1]);
        int[] a = new int[n];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int result = 0;
        // 공집합을 제외한 모든 집합을 구해봄, 전체 집합 = (1<<N)-1
        // i는 수열에서 숫자들을 선택하는 모든 경우의수를 말함
        for (int i=1; i<(1<<n); i++) {
            // 누적합 구하기
            int sum = 0;
            // k가 n까지 증가하면서 각각 k번째에 해당하는 숫자가 선택됬는지 확인하기
            for (int k=0; k<n; k++) {
                // k번째 숫자가 선택된 경우, 즉 존재하는 경우
                if ((i&(1<<k)) != 0) {
                    // 더해줌
                    sum += a[k];
                }
            }
            // 누적합이 문제에서 제시한 값과 같은 경우
            if (sum == s) {
                // 카운팅해주기
                result++;
            }
        }

        System.out.println(result);


    }
}