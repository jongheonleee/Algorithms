import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            times[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(times);

        int cumulativeTime = 0;
        int ans = 0;
        for (int time : times) {
            cumulativeTime += time;
            ans += cumulativeTime;
        }
        System.out.println(ans);
    }
}