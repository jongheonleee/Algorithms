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

 N개의 자연수 중에서 M개를 고른 수열
 1 ≤ M ≤ N ≤ 8
 중복되는 수열을 여러 번 출력하면 안됨
 같은 원수 중복 허용

 */
public class Main {

    /**
     * 수열 집합에 저장
     * 입력값 정렬
     * 백트랙킹 재귀적 구현
     *  - 깊이 m, 문자열 조합
     *  - 중복선택 가능
     */
    static int n, m;
    static int[] a;
    static boolean[] isSelected;
    static Set<String> coms = new LinkedHashSet<>();

    static void go(int depth, String com) {
        if (depth == m) {
            coms.add(com);
            return;
        }

        for (int i=0; i<n; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            go(depth+1,com + a[i] + " ");
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        a = new int[n];
        isSelected = new boolean[n];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            isSelected[i] = true;
            go(1, a[i] + " ");
            isSelected[i] = false;
        }
        coms.stream().forEach(com -> sb.append(com).append("\n"));
        System.out.print(sb.substring(0, sb.length()-2));
    }
}