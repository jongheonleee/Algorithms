import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair that) {
        if (this.first < that.first) {
            return -1;
        } else if (this.first == that.first) {
            if (this.second < that.second) {
                return -1;
            } else if (this.second == that.second) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] a = new Pair[n];
        for (int i=0; i<n; i++) {
            a[i] = new Pair(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(a);
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (a[i].second - i > ans) {
                ans = a[i].second - i;
            }
        }

        System.out.println(ans+1);

    }
}