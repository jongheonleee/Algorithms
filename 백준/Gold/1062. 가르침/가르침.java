import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static final int alphabets = (1<<26)-1;

    static int[] words;

    static int go(int i, int k, int mask) {
        // 종료조건
        if (k < 0) {
            return 0;
        }

        if (i == 26) {
            int cnt = counter(mask);
            return cnt;
        }
        int res = 0;
        // i 번째 글자를 사용하는 경우
        int tmp = go(i+1, k-1, mask | (1<<i));

        if (res < tmp) {
            res = tmp;
        }
        // i 번째 글자를 사용하지 않는 경우
        if (i != 'a'-'a' && i != 'n'-'a' && i != 't'-'a'
                && i != 'i'-'a' && i != 'c'-'a') {
            tmp = go(i+1, k, mask);

            if (res < tmp) {
                res = tmp;
            }
        }

        return res;
    }

    static int counter(int mask) {
        int cnt = 0;
        int notTaughtAlphabets = alphabets - mask;

        for (int word : words) {
            if ((word & notTaughtAlphabets) == 0) {
                cnt++;
            }
        }
        
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]), k = Integer.parseInt(line[1]);
        words = new int[n];

        for (int i=0; i<n; i++) {
            String word = br.readLine();
            for (char alphabet : word.toCharArray()) {
                words[i] |= (1 << alphabet - 'a');
            }
        }

        int ans = go(0, k, 0);
        System.out.println(ans);
    }
}