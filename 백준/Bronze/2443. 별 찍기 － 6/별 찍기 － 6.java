import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final String STAR = "*";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";
    private static final StringBuilder sb = new StringBuilder();

    private static void go(int n, int i) {
        if (i == n) return;

        for (int j=0; j<2*n-1-i;j++) {
            if (i <= j) sb.append(STAR);
            else sb.append(SPACE);
        }
        sb.append(ENTER);
        go(n, i+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        go(n, 0);
        System.out.println(sb);

    }
}
