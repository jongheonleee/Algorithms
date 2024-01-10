import java.util.*;
import java.io.*;


public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static final String STAR = "*";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

//    private static void go(int n, int i, int j) {
//        if (i == n) {
//            System.out.println(sb);
//            return;
//        }
//        int mid = (2*n-1)/2;
//        if (j < 2*n-1) {
//            if (i < n-1) {
//                if (j == mid-i || j == mid+i) {
//                    sb.append(STAR);
//                } else if (j < mid-i || mid-i<j&&j<mid+i) {
//                    sb.append(BLANK);
//                }
//                go(n, i, j+1);
//            } else {
//                sb.append(STAR);
//                go(n, i, j+1);
//            }
//        } else {
//            sb.append(ENTER);
//            go(n, i+1, 0);
//        }
//    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            for (int j=0; j<2*n; j++) {
                if (i%2 == 1) {
                    if (j%2 == 1) {
                        sb.append(STAR);
                    } else {
                        sb.append(BLANK);
                    }
                } else {
                    if (j%2 == 0) {
                        sb.append(STAR);
                    } else if (j%2 == 1 && j!=2*n-1){
                        sb.append(BLANK);
                    }
                }
            }
            sb.append(ENTER);
        }
        System.out.println(sb);

    }
}