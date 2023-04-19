import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;

        for (int start=1, len=1; len<=9; start*=10, len++) {
            int end = 10*start-1;
            if (end > n) {
                end = n;
                ans += (long)len*(end-start+1);
                break;
            }

            ans += (long)len*(end-start+1);
        }

        System.out.println(ans);
    }
}