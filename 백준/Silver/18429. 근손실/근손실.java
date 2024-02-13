import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * 문제요약
 * - 매일 k만큼 중량 줄어듦
 * - 대학원생은 운동 기간동안 항상 중량이 500 이상으로 유지가 되도록 N일간의 운동 플랜
 * - 운동 기간동안 항상 중량이 500 이상이 되도록 하는 경우의 수를 출력
 *
 * > 브루트포스로 모든 운동 플랜 적용
 * > 500이상 되는 경우만 카운트
 * > 재귀호출하다가 500 밑으로 떨어지면 중단
 */
public class Main {

    static int n, k, ans;
    static boolean[] isSelected;
    static int[] items;

    static void go(int i, int weight) {
        if (i == n) {
            if (weight >= 500) ans++;
            return;
        }

        // 백트랙킹
        if (weight < 500) return;

        for (int j=0; j<n; j++) {
            if (isSelected[j] == false) {
                isSelected[j] = true;
                go(i+1, weight+(items[j] - k));
                isSelected[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        // 0. 세팅
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        ans = 0;

        items = new int[n];
        isSelected = new boolean[n];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            items[i] = Integer.parseInt(line[i]);
        }


        // 1. 브루트포스(백트랙킹 적용)
        go(0, 500);
        // 2. 결과 출력
        System.out.println(ans);


    }
}

