import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cand = new int[9], ans = new int[7];
        int sum = 0;

        for (int i=0; i<9; i++) {
            int h = Integer.parseInt(br.readLine());
            cand[i] = h;
            sum += cand[i];
        }

        for (int i=0; i<8; i++) {
            for (int j=i+1; j<9; j++) {
                int tmp = cand[i] + cand[j];

                if (100 == sum - tmp) {
                    int l = 0;
                    for (int k=0; k<9; k++) {
                        if (k != i && k != j) {
                            ans[l] = cand[k];
                            l++;
                        }
                    }
                    break;
                }
            }
        }
        Arrays.sort(ans);
        for (int i=0; i<7; i++) {
            System.out.println(ans[i]);
        }

    }
}