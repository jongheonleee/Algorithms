import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.size() == right.size()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (!left.isEmpty() && !right.isEmpty()) {
                if (left.peek() > right.peek()) {
                    int tmp = right.poll();
                    right.offer(left.poll());
                    left.offer(tmp);
                }
            }
            sb.append(left.peek() + "\n");
        }

        System.out.println(sb);

    }

}