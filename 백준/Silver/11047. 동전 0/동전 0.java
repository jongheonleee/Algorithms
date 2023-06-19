import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);

        ArrayList<Integer> coins = new ArrayList<>();
        for (int i=0; i<n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        Collections.reverse(coins);
        int minCount = 0;

        for (int coin : coins) {
            if (k == 0) break;
            if (k < coin) continue;

            minCount += k / coin;
            k %= coin;
        }

        System.out.println(minCount);
    }
}