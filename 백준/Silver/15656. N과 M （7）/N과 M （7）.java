import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static Integer[] a;
    static StringBuilder sb = new StringBuilder();
    static String[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        a = new Integer[n];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        // 정렬시키기
        Arrays.sort(a);
        go(m, "");
        System.out.println(sb);

    }

    public static void go(int m, String sequence) {
        if (m == 0) {
            sb.append(sequence).append("\n");
            return;
        }

        for (int i=0; i<a.length; i++) {
            go(m-1, sequence + (a[i] + " "));
        }
    }

}