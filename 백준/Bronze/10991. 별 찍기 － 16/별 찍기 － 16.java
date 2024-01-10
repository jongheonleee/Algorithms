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
        int row = n, col = 2*n-1, mid = col/2;

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int left = mid - i, right = mid + i;
                if (left <= j && j <= right) {
                    if (i == 0 || (n%2 == 0 && i%2 != j%2) || (n%2 == 1 && i%2 == j%2)) {
                        sb.append(STAR);
                    } else {
                        sb.append(BLANK);
                    }
                } else if (j < left) {
                    sb.append(BLANK);
                }
            }
            sb.append(ENTER);
        }

        System.out.println(sb);
    }

}