import java.util.*;
import java.io.*;

/**
 *  N 장의 ‘공유 숫자카드’와 N 장의 ‘팀 숫자카드’를 받고 시작
 *  - 나 상대 각 n 공유 n
 *  상대 팀은 우리 팀의 ‘팀 숫자카드’ K 장을 견제
 *  - 견제된거 x
 *  우리 팀은 ‘공유 숫자카드’에서 한 장, ‘팀 숫자카드’ 중 한 장씩을 골라
 *  - 공유 1, 팀 숫자 1
 *  > 공유의 최대값, 팀 최대값
 *  두 카드의 곱이 우리 팀의 점수가 되며 이후 같은 방식으로 상대 팀도 진행하여 상대 팀의 점수보다 높을 경우 이김
 *
 *  상대팀은 항상 최선의 방법으로 N장의 우리 팀의 ‘팀 숫자카드’ 중 K장을 견제한다고 했을 때, 우리 팀이 얻을 수 있는 최대 점수
 *  - 가장 높은 숫자 k 개 견제
 */
public class Main {

    private static final int MIN = -100_000;
    private static int n, k;
    private static int[] share;
    private static int[] team;
    private static boolean[] check;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);

        share = new int[n];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            share[i] = Integer.parseInt(line[i]);
        }

        team = new int[n];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            team[i] = Integer.parseInt(line[i]);
        }

        check = new boolean[n];

        for (int i=0; i<k; i++) {
            int max = MIN;
            int idx = -1;

            for (int j=0; j<n; j++) {
                for (int l=0; l<n; l++) {
                    if (check[l]) continue;
                    if (max < share[j] * team[l]) {
                        max = share[j] * team[l];
                        idx = l;
                    }
                }
            }

            check[idx] = true;
        }

        int ans = MIN;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (check[j]) continue;
                ans = share[i] * team[j] > ans ? share[i] * team[j] : ans;
            }
        }
        System.out.println(ans);

   }
}
