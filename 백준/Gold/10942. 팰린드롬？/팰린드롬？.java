import java.util.*;
import java.io.*;




public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int[][] isPalindrome = new int[n][n];
        for (int i=0; i<n; i++) {
            int left = i;
            int right = i;

            while (0 <= left) {
                if (a[left] == a[i]) {
                    isPalindrome[left][i] = 1;
                    left--;
                } else {
                    break;
                }
            }

            while (right < n) {
                if (a[i] == a[right]) {
                    isPalindrome[i][right] = 1;
                    right++;
                } else {
                    break;
                }
            }

            left = i;
            right = i;
            while (0 <= left && right < n) {
                if (a[left] == a[right]) {
                    isPalindrome[left][right] = 1;
                    left--; right++;
                } else {
                    break;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            bw.write(isPalindrome[from][to]+"\n");
        }

        bw.flush();
        bw.close();
     }
}