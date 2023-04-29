import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] s;
    static int go(int num, ArrayList<Integer> first, ArrayList<Integer> second) {
        // 정답을 찾은 경우 or 종료 경우
        if (num == n) {
            // 종료 경우
            if (first.size() != n/2 || second.size() != n/2) return -1;

            // 정답을 찾은 경우
            int sum1 = 0, sum2 = 0;
            for (int i=0; i<n/2; i++) {
                for (int j=0; j<n/2; j++) {
                    sum1 += s[first.get(i)][first.get(j)];
                    sum2 += s[second.get(i)][second.get(j)];
                }
            }

            int diff = Math.abs(sum1 - sum2);
            return diff;
        }

        // 재귀 호출하는 경우
        // 첫 번째 팀을 선택하는 경우
        int result = -1;
        first.add(num);
        int v1 = go(num+1, first, second);
        if (result == -1 || v1 != -1 && result > v1) {
            result = v1;
        }
        first.remove(first.size()-1);

        // 두 번째 팀을 선택하는 경우
        second.add(num);
        int v2 = go(num+1, first, second);
        if (result == -1 || v2 != -1 && result > v2) {
            result = v2;
        }
        second.remove(second.size()-1);

        return result;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        String[] line;

        for (int i=0; i<n; i++) {
            line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                s[i][j] = Integer.parseInt(line[j]);
            }
        }

        ArrayList<Integer> first = new ArrayList<>(), second = new ArrayList<>();
        int result = go(0, first, second);
        System.out.println(result);
    }
}