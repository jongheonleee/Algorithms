import java.io.*;
import java.util.*;

public class Main {

    static int[] preprocessing(String p) {
        int m = p.length();
        int[] pi = new int[m];

        int j = 0;
        pi[0] = 0;

        for (int i=1; i<m; i++) {
            while (j>0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j-1];
            }

            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = j+1;
                j = j+1;
            } else {
                pi[i] = 0;
            }
        }

        return pi;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] pi = preprocessing(s);
        int n = s.length();

        int[] cnt = new int[n+1];
        for (int i=0; i<n; i++) {
            cnt[pi[i]] += 1;
        }

        for (int i=n; i>0; i--) {
            cnt[pi[i-1]] += cnt[i];
        }

        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();

        for (int i=n; i>0; i=pi[i-1]) {
            ans1.add(i);
            // 1을 더한 이유 파악하기
            ans2.add(cnt[i]+1);
        }

        int m = ans1.size();
        System.out.println(m);
        for (int i=m-1; i>=0; i--) {
            System.out.println(ans1.get(i) + " " + ans2.get(i));
        }
    }
}