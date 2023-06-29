import java.io.*;
import java.util.*;

public class Main {


    // target 보다 크거나 같은 수 중에서 첫번째 위치를 반환
    public static int lower_bound(int[] cards, int target) {
        int left = 0, right = cards.length-1, pos = 0;

        while (left <= right) {
            int mid = (left + right) /2;

            if (cards[mid] == target) {
                pos = mid;
                right = mid - 1;
            }

            else if (cards[mid] > target) {
                right = mid - 1;
            }
            else if (cards[mid] < target) {
                left = mid + 1;
            }

        }
        return pos;

    }

    // target 보다 큰 수 중에서 첫번째 위치를 반환
    public static int upper_bound(int[] cards, int target) {
        int left = 0, right = cards.length-1, pos = 0;

        while (left <= right) {
            int mid = (left + right) /2;

            if (cards[mid] == target) {
                left = mid + 1;
                pos = left;
            }

            else if (cards[mid] > target) {
                right = mid - 1;
            }
            else if (cards[mid] < target) {
                left = mid + 1;
            }

        }
        return pos;

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
            int idx1 = lower_bound(cards, targets[i]);
            int idx2 = upper_bound(cards, targets[i]);

            sb.append(idx2-idx1).append(" ");
        }

        System.out.println(sb);
    }
}