import java.util.*;
import java.io.*;


public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static final String STAR = "*";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mid = (2*n-1)/2;
        for (int i=0; i<n; i++) {
            for (int j=0; j<2*n-1; j++) {
                if (i == 0) {
                    if (j == mid) {
                        sb.append(STAR);
                    } else if (j < mid - i){
                        sb.append(BLANK);
                    }
                } else if (0 < i && i < n-1) {
                    if (j == mid - i || j == mid + i) {
                        sb.append(STAR);
                    } else if (j < mid - i || mid - i < j && j < mid + i){
                        sb.append(BLANK);
                    }
                } else {
                    // i == n
                    sb.append(STAR);
                }
            }
            sb.append(ENTER);
        }

        System.out.println(sb);
    }
}