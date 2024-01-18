import java.util.*;
import java.io.*;



public class Main {
    static Set<String> set = new HashSet<>();
    static int n;
    static int k;
    static int[] isLeft;
    static void go(int count, String current) {
        if (count == k) {
            set.add(current);
            return;
        }

        for (int i=0; i<100; i++) {
            if (isLeft[i] > 0) {
                isLeft[i] -= 1;
                go(count+1, current+i);
                isLeft[i] += 1;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        isLeft = new int[100];
        for (int i=0; i<n; i++) {
            int number = Integer.parseInt(br.readLine());
            isLeft[number] += 1;
        }
        go(0, "");
        System.out.println(set.size());

    }
}

