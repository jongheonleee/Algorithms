import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final String STAR = "*";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // top
        for (int i=0; i<n; i++) {
            for (int j=0; j<=(n-1) + i; j++) {
                if ((n-1) - i <= j && j <= (n-1) + i) {
                    sb.append(STAR);
                } else {
                    sb.append(SPACE);
                }
            }
            sb.append(ENTER);
        }


        // bottom, except for first line
        for (int i=0; i<n; i++) {
            if (i == 0) continue;
            for (int j=0; j<2*n-1-i; j++) {
                if (j >= i) {
                    sb.append(STAR);
                } else {
                    sb.append(SPACE);
                }
            }
            sb.append(ENTER);
        }

        System.out.println(sb);

    }
}
