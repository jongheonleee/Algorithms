import java.io.*;
import java.util.*;


public class Main {

    static final int MAX = 100;

    static int[] parents = new int[MAX+1];

    static void union(int x, int y) {
        int xHead = find(x);
        int yHead = find(y);

        if (xHead == yHead) {
            return;
        } else {
            parents[yHead] = xHead;
        }

    }

    static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++) {
            parents[i] = i;
        }

        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            union(x, y);
        }

        int cnt = 0;
        for (int i=2; i<=n; i++) {
            if (find(1) == find(i)) {
                cnt += 1;
            }
        }
        System.out.println(cnt);

    }
}