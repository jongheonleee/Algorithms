import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            long m = sc.nextLong();

            if (m == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(minHeap.poll()).append("\n");
                }
            } else {
                minHeap.add(m);
            }
        }

        System.out.println(sb);

    }
}