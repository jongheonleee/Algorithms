import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static boolean[] prime;
    static ArrayList<Integer> primes;

    static void getPrimes() {
        primes = new ArrayList<>();
        prime[0] = true;
        prime[1] = true;

        for (int i=2; i*i<=n; i++) {
            if (!prime[i]) {
                for (int j=i*i; j<=n; j+=i) prime[j] = true;
            }
        }

        for (int i=1; i<=n; i++) {
            if (!prime[i]) {
                primes.add(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        prime = new boolean[n+1];

        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }


        getPrimes();
        Integer[] a = primes.toArray(new Integer[primes.size()]);

        int left = 0, right = 0, sum = a[0], ans = 0;
        if (!prime[n]) ans += 1;
        while (left <= right && right < a.length-1) {
            if (sum == n) {
                ans += 1;
                right += 1;
                sum += a[right];
            } else if (sum > n) {
                sum -= a[left];
                left += 1;
                if (left > right && left < a.length) {
                    right = left;
                    sum = a[right];
                }
            } else {
                right += 1;
                sum += a[right];

            }
        }

        System.out.println(ans);

    }
}