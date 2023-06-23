import java.util.*;
import java.io.*;

class Lecture implements Comparable<Lecture> {
    int price;
    int day;

    Lecture(int price, int day) {
        this.price = price;
        this.day = day;
    }

    // d에 대해서 내림차순 적용
    @Override
    public int compareTo(Lecture that) {
        if (this.day < that.day) {
            return 1;
        } else if (this.day == that.day) {
            if (this.price < that.price) {
                return -1;
            } else if (this.price == that.price) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }
}


public class Main {

    private static final int MAX = 10000;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] list = new Lecture[n];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            list[i] = new Lecture(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        Arrays.sort(list);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0, k = 0;


        for (int i=MAX; i>=1; i--) {
            while (k < n && list[k].day == i) {
                q.offer(-list[k].price);
                k++;
            }

            if (!(q.isEmpty())) {
                ans += -q.poll();
            }
        }

        System.out.println(ans);
    }
}