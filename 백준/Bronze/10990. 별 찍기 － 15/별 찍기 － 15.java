import java.util.*;
import java.io.*;


public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static final String STAR = "*";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

    private static void go(int n, int i, int j) {
        if (i == n) {
            System.out.println(sb);
            return;
        }

        if (j < 2*n-1) {
            int mid = (2*n-1)/2;
            if (j == mid-i || j ==mid+i) {
                sb.append(STAR);
            } else if (j <= mid+i) {
                sb.append(BLANK);
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
        go(n, 0, 0);
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<2*n-1; j++) {
//                int mid = (2*n-1)/2;
//                if (j == mid - i || j == mid + i) {
//                    sb.append(STAR);
//                } else if (j <= mid + i) {
//                    sb.append(BLANK);
//                }
//            }
//            sb.append(ENTER);
//        }
//
//        System.out.println(sb);
    }

}