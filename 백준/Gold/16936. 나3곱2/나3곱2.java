import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int three;
    long num;

    Pair(int three, long num) {
        this.three = three;
        this.num = num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(three, num);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair that = (Pair) obj;

            if (this.three == that.three && this.num == that.num) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Pair that) {
        if (this.three > that.three) {
            return -1;
        } else if (this.three == that.three) {
            if (this.num < that.num) return -1;
            else if (this.num == that.num)  return 0;
            else return 1;
        } else {
            return 1;
        }
    }
}



public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Pair[] a = new Pair[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            long num = Long.parseLong(line[i]);
            int three = 0;
            for (long j=num; j%3 == 0; j/=3) {
                three += 1;
            }
            a[i] = new Pair(three, num);
        }
        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            sb.append(a[i].num).append(" ");
        }
        System.out.println(sb);
    }
}