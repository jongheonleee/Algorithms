import java.util.*;
import java.io.*;


public class Main {

    private static final String STAR = "*";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";
    private static StringBuilder sb = new StringBuilder();
    

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=2*n-1; i++) {
            for (int j=1; j<=2*n; j++) {
                if (!((i>j && i+j<2*n)||(i+j>=2*n+1&&j>=i+1))) {
                    sb.append(STAR);
                } else if (j <= n){
                    sb.append(SPACE);
                }
            }
            sb.append(ENTER);
        }

        System.out.println(sb);

    }
}