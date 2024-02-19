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
 비내림차순(A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK)
 1 ≤ M ≤ N ≤ 8
 중복되는 수열을 여러 번 출력하면 안됨
 같은 원수 중복 허용 하지만 그 보다 작은 원소 선택 x

 */
public class Main {

    static int n, m;
    static int[] a;
    static Set<String> coms = new LinkedHashSet<>();
    static void go(int idx, int depth, String com) {
        if (depth == m) {
            coms.add(com);
            return;
        }

        for (int i=idx+1; i<n; i++) {
            go(i, depth+1, com + a[i] + " ");
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

        for (int i=0; i<n; i++) {
            go(i, 1, a[i] + " ");
        }
        coms.stream().forEach(com -> sb.append(com).append("\n"));
        System.out.print(sb.substring(0, sb.length()-2));
    }
}
