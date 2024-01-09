import java.util.*;
import java.io.*;


public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static final String STAR = "*";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

    private static void go(int n, int i, int j) {
        if (i == 2*n-1) {
            System.out.println(sb);
            return;
        }

        if (j < n) {
            if ((i<n&&i>=j)||(i>=n&&i+j<2*n-1)) {
                sb.append(STAR);
            }
            go(n, i, j+1);
        } else {
            sb.append(ENTER);
            go(n, i+1, 0);
        }

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<2*n-1; i++) {
            for (int j=0; j<n; j++) {
                if ((i < n && i >= j) || (i >= n && i+j < 2*n-1)) {
                    sb.append(STAR);
                }
            }
            sb.append(ENTER);
        }

        System.out.println(sb);
    }
}