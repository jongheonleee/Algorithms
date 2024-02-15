import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;


/**
문제 요약
 - 1부터 N까지 자연수 중에서 M개를 고른 수열
 - 같은 수를 여러 번 골라도 된다
 */
public class Main {


    static int n, m;
    static StringBuilder sb;
    static int[] selected;

    static void go(int i) {
        if (i == m) {
            for (int k=0; k<m; k++) {
                sb.append(selected[k]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int k=1; k<=n; k++) {
            selected[i] = k;
            go(i+1);
            selected[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] line = br.readLine().split(" ");
        // 0. 세팅
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        selected = new int[m];
        sb = new StringBuilder(n*m*2+5);

        go(0);
        System.out.println(sb);
    }
}

