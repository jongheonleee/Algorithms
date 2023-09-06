import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMin = new PriorityQueue<>();

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (leftMax.size() == rightMin.size()) {
                leftMax.offer(num);
            } else {
                rightMin.offer(num);
            }

            if (!leftMax.isEmpty() && !rightMin.isEmpty()) {
                if (leftMax.peek() > rightMin.peek()) {
                    int tmp = leftMax.poll();
                    leftMax.offer(rightMin.poll());
                    rightMin.offer(tmp);
                }
            }
            bw.write(leftMax.peek() + "\n");
        }
        bw.flush();
        bw.close();
        
    }
}