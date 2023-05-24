import java.util.*;
import java.io.*;
public class Main {

    static final int LIMIT = 256;

    static int[] alphaToNum = new int[LIMIT];

    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i] <= a[i-1])
            i--;

        if (i <= 0) return false;

        int j = a.length-1;
        while (j > i && a[j] <= a[i-1])
            j--;

        int tmp = a[i-1];
        a[i-1] = a[j]; a[j] = tmp;

        j = a.length-1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j]; a[j] = tmp;

            i++; j--;
        }

        return true;

    }

    static int calc(String[] words, Character[] letters, int[] num) {
        int m = letters.length;
        int sum = 0;

        for (int i=0; i<m; i++) {
            char alphabet = letters[i];
            alphaToNum[alphabet] = num[i];
        }

        for (String word : words) {
            int now = 0;
            for (char alphabet : word.toCharArray()) {
                now = now*10 + alphaToNum[alphabet];
            }

            sum += now;
        }

        return sum;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        HashSet<Character> set = new HashSet<>();

        for (int i=0; i<n; i++) {
            words[i] = br.readLine();
            String word = words[i];
            for (char alphabet : word.toCharArray()) {
                set.add(alphabet);
            }
        }

        Character[] letters = set.toArray(new Character[set.size()]);

        int m = letters.length;
        int[] num = new int[m];

        for (int i=0; i<m; i++) {
            num[i] = 9-i;
        }

        Arrays.sort(num);
        int ans = 0;
        
        do {
            int res = calc(words, letters, num);
            if (res > ans) {
                ans = res;
            }
        } while (next_permutation(num));

        System.out.println(ans);
    }
}