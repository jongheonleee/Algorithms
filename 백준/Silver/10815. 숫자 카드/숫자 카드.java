import java.io.*;
import java.util.*;

public class Main {

    static final int POSSIBLE = 1;
    static final int IMPOSSIBLE = 0;

    public static int binary_search(int[] cards, int target) {
        int left = 0, right = cards.length-1;

        while (left <= right) {
            int mid = (left + right) /2;

            if (cards[mid] == target) return POSSIBLE;

            else if (cards[mid] > target) {
                right = mid - 1;
            }
            else if (cards[mid] < target) {
                left = mid + 1;
            }

        }

        return IMPOSSIBLE;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        String[] line1 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(line1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];

        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<m; i++) {
            targets[i] = Integer.parseInt(line2[i]);
        }

        Arrays.sort(cards);

        for (int i=0; i<m; i++) {
            sb.append(binary_search(cards, targets[i]) + " ");
        }

        System.out.println(sb);
    }
}