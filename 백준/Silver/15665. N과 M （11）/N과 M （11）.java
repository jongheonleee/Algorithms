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

 N개의 자연수 중에서 M개를 고른 수열, 중복 허용
 1 ≤ M ≤ N ≤ 7

 LinkedHashSet에 저장
 sb 출력형식 맞추기

 백트랙킹, 재귀적 호출

 */
public class Main {
    static int n, m;
    static int[] a;
    static Set<String> coms = new LinkedHashSet<>();

    static void go(int depth, String com) {
        if (depth == m) {
            coms.add(com);
            return;
        }

        for (int i=0; i<n; i++) {
            go(depth+1, com + a[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();

        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(a);
        go(0, "");
        coms.stream().forEach(com -> sb.append(com).append("\n"));
        sb.substring(0, sb.length()-2);
        System.out.print(sb);
    }
}

