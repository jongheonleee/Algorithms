import java.util.*;
import java.io.*;


public class Main {

    private static final String STAR = "*";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";
    private static StringBuilder sb = new StringBuilder();

    private static void go(int n, int i) {
        if (i > n) return;

        for (int j=1; j<=2*n-1; j++) {
            if (j == n || ((n-(i-1) <= j && j <= (n+(i-1))))) {
                sb.append(STAR);
            } else if (j < n-(i-1)) {
                sb.append(SPACE);
            }
        }
        sb.append(ENTER);
        go(n, i+1);
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        go(n, 1);
        System.out.println(sb);
    }
}