import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final String STAR = "*";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            for (int j=0; j<2*n-1-i; j++) {
                if (i <= j && j < 2*n-1-i) {
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











