import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {
    static int n, ans;
    static char[] board, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        n = line.length();
        ans = 0;

        board = new char[n];
        result = new char[n];

        for (int i=0; i<n; i++) {
            char token = line.charAt(i);
            if (token == '.') result[i] = token;
            board[i] = token;
        }

        int i = 0;
        outer : while(i<n) {
            if (board[i] == '.') i++;
            else {
                int j = i+1;
                while (j<n && board[j] == 'X') {
                    j++;
                }
                int len = j-i;
                if (len%2 == 1) {
                    ans = -1;
                    break outer;
                }

                int k1 = len/4;
                for (int k=1; k<=k1; k++) {
                    result[i] = result[i+1] = result[i+2] = result[i+3] = 'A';
                    i += 4;
                }

                len = len - 4*k1;
                int k2 = len/2;
                for (int k=1; k<=k2; k++) {
                    result[i] = result[i+1] = 'B';
                    i += 2;
                }
            }
        }

        if (ans == -1) {
            System.out.println(ans);
        } else {
            for (int k=0; k<n; k++) {
                sb.append(result[k]);
            }
            System.out.print(sb);
        }
    }
}