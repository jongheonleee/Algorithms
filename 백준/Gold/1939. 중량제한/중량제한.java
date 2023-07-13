import java.util.*;
class Edge {
    int to, cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    static ArrayList<Edge>[] a = new ArrayList[10001];
    static boolean[] check = new boolean[10001];
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
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Edge>();
        }
        while (m-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            a[from].add(new Edge(to, cost));
            a[to].add(new Edge(from, cost));
        }
        start = sc.nextInt();
        end = sc.nextInt();
        int left = 1;
        int right = 1000000000;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right-left)/2;
            Arrays.fill(check,false);
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