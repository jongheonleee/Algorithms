import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair that) {
        if (this.x < that.x) {
            return -1;
        } else if (this.x == that.x) {
            if (this.y < that.y) {
                return -1;
            } else if (this.y == that.y) {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Pair[] a = new Pair[n];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            a[i] = new Pair(x, y);
        }

        Arrays.sort(a);
        for (Pair p : a) {
            bw.write(p.x + " " + p.y + "\n");

        }
        bw.flush();
    }
}