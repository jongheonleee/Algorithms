import java.util.*;
import java.io.*;


public class Main {
    static int n;
    static int m;
    static int ans;
    static int[][] score;
    static void go(int i, int j, int[] selected) {
        if (j == 3) {
            int sum = 0;
            for (int k=0; k<n; k++) {
                int max = 0;
                for (int l=0; l<selected.length; l++) {
                    int selectedIdx = selected[l];
                    if (max < score[k][selectedIdx]) max = score[k][selectedIdx];
                }
                sum += max;
            }
            if (ans < sum) ans = sum;
            return;
        }

        if (i >= m)return;

        selected[j] = i;
        go(i+1, j+1, selected);

        selected[j] = 0;
        go(i+1, j, selected);

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        score = new int[n][m];

        for (int i=0; i<n; i++) {
            String[] line2 = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                score[i][j] = Integer.parseInt(line2[j]);
            }
        }
        go(0, 0, new int[3]);
        System.out.println(ans);
    }

}
