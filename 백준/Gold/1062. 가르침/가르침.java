import java.util.*;
public class Main {

    static final int alphabets = 26;
    static boolean[] learn = new boolean[alphabets];
    static int count(String[] words) {
        int cnt = 0;
        for (String word : words) {
            boolean ok = true;
            for (char x : word.toCharArray()) {
                if (!learn[x-'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok) cnt += 1;
        }
        return cnt;
    }
    
    // k개의 글자를 배우는 모든 경우(불필요한 경우 제외)를 구해보고 그때의 읽을 수 있는 단어를 카운팅해줌
    static int go(int index, int k, String[] words) {
        if (k < 0) return 0;
        if (index == 26) {
            return count(words);
        }

        int ans = 0;
        // index 번째 글자를 배운 경우
        learn[index] = true;
        int t1 = go(index+1, k-1, words);
        learn[index] = false;
        if (ans < t1) ans = t1;

        // 배우지 않는 경우
        // 밑에 조건문은 해당 글자들은 반드시 배워야 하는 글자이므로 해당 글자일 경우 무조건 배우게함
        if (index != 'a'-'a' && index != 'n'-'a' && index != 't'-'a' && index != 'i'-'a' && index != 'c'-'a') {
            t1 = go(index+1, k, words);
            if (ans < t1) ans = t1;
        }
        
        // 읽을 수 있는 단어의 최대 개수 반환
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] words = new String[n];
        for (int i=0; i<n; i++) {
            words[i] = sc.next();
        }

        System.out.println(go(0,m,words));
    }
}