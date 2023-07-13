import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int to, cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    static final int MAX = 10000;
    static final int MAX2 = 1_000_000_000;
    static ArrayList<Edge>[] a = new ArrayList[MAX+1];
    static boolean[] check = new boolean[MAX+1];
    static int n, m, start, end;

    static boolean go(int node, int limit) {
        if (check[node]) return false;
        
        check[node] = true;
        
        if (node == end) return true;
        
        for (Edge e : a[node]) {
            int next = e.to;
            int cost = e.cost;
            
            if (cost >= limit) {
                if (go(next, limit)) return true;
            }
        }
        
        return false;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]); m = Integer.parseInt(line1[1]);


        for (int i=1; i<=n; i++) a[i] = new ArrayList<Edge>();

        while (m-- > 0) {
            String[] line2 = br.readLine().split(" ");
            int from = Integer.parseInt(line2[0]);
            int to = Integer.parseInt(line2[1]);
            int cost = Integer.parseInt(line2[2]);

            a[from].add(new Edge(to, cost));
            a[to].add(new Edge(from, cost));
        }

        String[] line3 = br.readLine().split(" ");
        start = Integer.parseInt(line3[0]); end = Integer.parseInt(line3[1]);

        int left = 1, right = MAX2, ans =0;
        
        while (left <= right) {
            int mid = left + (right-left)/2;
            
            Arrays.fill(check, false);
            
            if (go(start, mid)) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(ans);

    }
}