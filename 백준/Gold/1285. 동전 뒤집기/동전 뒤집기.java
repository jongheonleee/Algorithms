import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static char flip(char coin) {
        if (coin == 'H') {
            return 'T';
        }
        else {
            return 'H';
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] table = new char[n][n];
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            table[i] = line.toCharArray();
        }

        int ans = n*n;
        for (int state=0; state<(1<<n); state++) {
            int sum = 0;

            for (int j=0; j<n; j++) {
                int cnt = 0;

                for (int i=0; i<n; i++) {
                    char coin = table[i][j];
                    if (((1<<i) & state) != 0) {
                        coin = flip(table[i][j]);
                    }

                    if (coin == 'T') {
                        cnt++;
                    }
                }

                sum += Math.min(cnt, n-cnt);
            }

            if (sum < ans) {
                ans = sum;
            }
        }
        System.out.println(ans);
    }
}