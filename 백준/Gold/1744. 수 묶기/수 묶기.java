import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int zero = 0, one = 0;
        ArrayList<Integer> negative = new ArrayList<>(), positive = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) zero++;
            if (num == 1) one++;
            if (num < 0) negative.add(num);
            if (num > 1) positive.add(num);
        }

        Collections.sort(negative);
        if (negative.size() % 2 == 1) {
            negative.add(zero > 0 ? 0 : 1);
        }

        Collections.sort(positive);
        Collections.reverse(positive);
        if (positive.size() % 2 == 1) {
            positive.add(1);
        }

        int ans = one;
        for (int i=0; i<negative.size()-1; i+=2) {
            int n1 = negative.get(i), n2 = negative.get(i+1);

            ans += (n1 * n2);
        }

        for (int i=0; i<positive.size()-1; i+=2) {
            int n1 = positive.get(i), n2 = positive.get(i+1);

            ans += (n1 * n2);
        }

        System.out.println(ans);
    }
}