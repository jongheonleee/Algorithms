import java.util.*;
import java.io.*;



public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        String[] board = new String[n];
        for (int i=0; i<n; i++) {
            String dna = br.readLine();
            board[i] = dna;
        }

        String ans = "";
        int sum = 0;
        for (int j=0; j<m; j++) {
            // 0 : A, 1 : C, 2 : G, 3 : T
            int[] tmp = new int[4];
            for (int i=0; i<n; i++) {
                char ch = board[i].charAt(j);
                if (ch == 'A') tmp[0]++;
                if (ch == 'C') tmp[1]++;
                if (ch == 'G') tmp[2]++;
                if (ch == 'T') tmp[3]++;
            }

            int max = tmp[0], maxIdx = 0;
            for (int k=0; k< tmp.length; k++) {
                if (max < tmp[k]) {
                    max = tmp[k];
                    maxIdx = k;
                }
            }

            if (maxIdx == 0) {
                ans += "A";
            } else if (maxIdx == 1) {
                ans += 'C';
            } else if (maxIdx == 2) {
                ans += 'G';
            } else {
                ans += 'T';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<ans.length(); j++) {
                if (ans.charAt(j) != board[i].charAt(j)) {
                    sum++;
                }
            }
        }

        System.out.println(ans);
        System.out.println(sum);
    }
}
