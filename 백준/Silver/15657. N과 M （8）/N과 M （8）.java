import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;


/**
문제 요약

 N개의 자연수 중에서 M개를 고른 수열, 중복허용, 비내림차순
 1 ≤ M ≤ N ≤ 7
 */
public class Main {


    static int n, m;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    // 순열 만들기 -> 브루트포스, 백트랙킹
    // n에서 m개 선정, 중복허용
    // 브루트포스, 백트랙킹
        // 깊이 m까지 탐색
        // 각 단계에서 숫자 한개 선정
        // m+1까지 도달하면 해당 문자열 저장 재귀호출 종료

    static void go(int depth, int start, String com) {
        if (depth == m) {
            sb.append(com).append("\n");
            return;
        }

        for (int i=start; i<n; i++) {
            go(depth+1, i,com + numbers[i] + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        go(0, 0, "");
        System.out.print(sb);
    }
}

