import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int MAX = Integer.MAX_VALUE;
    static int E;
    static int S;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (E == 15) E = 0;
        if (S == 28) S = 0;
        if (M == 19) M = 0;

        for (int y=1; y<MAX; y++) {
            if (y%15 == E && y%28 == S && y%19 == M) {
                System.out.println(y);
                break;
            }
        }
    }

}