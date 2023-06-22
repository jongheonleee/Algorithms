import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        String[] line = br.readLine().split(" ");

        for (int i=0; i<n; i++) {
            times[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(times);
        int ans = 0, acc = 0;

        for (int time : times) {
            acc += time;
            ans += acc;
        }

        System.out.println(ans);
    }

}