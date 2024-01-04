import java.util.*;
import java.io.*;


public class Main {

    private static final String STAR = "*";
    private static final String ENTER = "\n";
    private static StringBuilder sb = new StringBuilder();

    private static void go(int n, int len) {
        if (n < len) return;
        for (int i=1; i<=len; i++) {
            sb.append(STAR);
        }
        sb.append(ENTER);
        go(n, len+1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        go(n, 1);
        System.out.println(sb);
    }
}