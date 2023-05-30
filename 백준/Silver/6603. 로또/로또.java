import javax.swing.*;
import java.util.*;
import java.io.*;
public class Main {
    static final int NUMBER = 6;
    static StringBuilder sb = new StringBuilder();
    static void go(int[] a, int i, int cnt, ArrayList<Integer> lotto) {
        if (cnt == NUMBER) {
            for (int j=0; j<NUMBER; j++) {
                sb.append(lotto.get(j)).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        if (i == a.length) return;
        
        lotto.add(a[i]);
        go(a, i+1, cnt+1, lotto);
        lotto.remove(lotto.size()-1);
        go(a, i+1, cnt, lotto);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String[] line = br.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            
            if (k == 0) break;
            
            int[] a = new int[k];
            for (int i=1; i<=k; i++) {
                a[i-1] = Integer.parseInt(line[i]);
            }
            
            ArrayList<Integer> lotto = new ArrayList<>();
            go(a, 0, 0, lotto);
            sb.append("\n");
        }

        System.out.println(sb);

    }
}