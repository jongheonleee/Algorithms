import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] path;
    static int[] a;
    static int[] d;

    static Stack<Integer> stack = new Stack<>();


    public static void go(int i) {
        if (path[i] == -1) {
            stack.add(i);
            return;
        }

        stack.add(i);
        go(path[i]);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        a = new int[n]; d = new int[n]; path = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        // dp 알고리즘
        for (int i=0; i<n; i++) {
            d[i] = 1;
            path[i] = -1;
            for (int j=0; j<i; j++) {
                if (a[i] > a[j] && d[i] < 1 + d[j]) {
                    d[i] = 1 + d[j];
                    path[i] = j;
                }
            }
        }

        // 최대값 찾기
        int len = 0, p = 0;
        for (int i=0; i<n; i++) {
            if (len < d[i]) {
                len = d[i];
                p = i;
            }
        }

        // 경로 찾기 stack에 넣고
        go(p);
        // 뒤집기 stack에서 빼기(출력하기)
        while(!stack.isEmpty()) {
            int x = stack.pop();
            sb.append(a[x]).append(" ");
        }
        System.out.println(len);
        System.out.println(sb);

    }
}