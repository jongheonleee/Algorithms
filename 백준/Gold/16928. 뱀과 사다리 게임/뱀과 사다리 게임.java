import javax.swing.*;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] board = new int[101];
        int[] next = new int[101];
        int[] count = new int[101];

        // 기본 세팅
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
            next[i] = i;
            count[i] = -1;
        }

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);

        for (int i=0; i<n+m; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]), y = Integer.parseInt(line[1]);

            next[x] = y;
        }

        // bfs 적용
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        count[1] = 0;

        while (!q.isEmpty()) {
            int x = q.remove();

            for (int i=1; i<=6; i++) {
                int y = x+i;
                if (y > 100) continue;
                y = next[y];
                if (count[y] != -1) continue;
                count[y] = count[x]+1;
                q.add(y);
            }
        }

        System.out.println(count[100]);
    }

}