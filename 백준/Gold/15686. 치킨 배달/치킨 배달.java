import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][n];
        ArrayList<Pair> stores = new ArrayList<>();
        ArrayList<Pair> houses = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(line[j]);

                if (a[i][j] == 1) {
                    houses.add(new Pair(i, j));
                } else if (a[i][j] == 2) {
                    stores.add(new Pair(i, j));
                }
            }
        }

        int[] d = new int[stores.size()];
        for (int i=0; i<m; i++) {
            d[i] = 1;
        }

        Arrays.sort(d);
        int ans = -1;

        do {
            int sum = 0;
            for (Pair house : houses) {
                int min = -1;
                
                for (int i=0; i< stores.size(); i++) {
                    if (d[i] == 0) continue;
                    
                    Pair store = stores.get(i);
                    
                    int d1 = house.x - store.x;
                    int d2 = house.y - store.y;
                    
                    if (d1 < 0) d1 = -d1;
                    if (d2 < 0) d2 = -d2;
                    
                    int dist = d1+d2;
                    if (min == -1 || min > dist) min = dist;
                }
                sum += min;
            }
            if (ans == -1 || ans > sum) ans = sum;
        } while (next_permutation(d));
        System.out.println(ans);

    }
}