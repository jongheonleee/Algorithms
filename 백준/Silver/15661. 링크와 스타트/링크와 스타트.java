import java.util.*;
import java.io.*;
public class Main {

    static int[][] s;
    static int n;

    public static int go(int num, ArrayList<Integer> first, ArrayList<Integer> second) {
        // 종료 조건 & 정답을 찾은 경우
        if (num == n) {
            // 종료 조건
            if (first.size() == 0 || second.size() == 0) return -1;

            // 정답을 찾은 경우
            int sum1 = 0, sum2 = 0, diff = 0;
            for (int i=0; i<first.size(); i++) {
                for (int j=0; j<first.size(); j++) {
                    sum1 += s[first.get(i)][first.get(j)];
                }
            }

            for (int i=0; i<second.size(); i++) {
                for (int j=0; j<second.size(); j++) {
                    sum2 += s[second.get(i)][second.get(j)];
                }
            }

            diff = Math.abs(sum1 - sum2);

            return diff;
        }

        // 재귀를 호출하는 경우
        // num에 해당 하는 선수가 1 팀을 선택한 경우
        int result = -1;
        int v1 = 0, v2 = 0;
        first.add(num);
        v1 = go(num+1, first, second);
        if (result == -1 || (v1 != -1 && result > v1)) result = v1;
        first.remove(first.size()-1);

        second.add(num);
        v2 = go(num+1, first, second);
        if (result == -1 || (v2 != -1 && result > v2)) result = v2;
        second.remove(second.size()-1);

        return result;
    }

    public static void main(String[] args) throws IOException {
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