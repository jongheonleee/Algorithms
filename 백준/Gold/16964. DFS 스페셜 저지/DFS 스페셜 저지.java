import java.util.*;
public class Main {

    static ArrayList<Integer>[] a;
    static boolean[] check;

    static int[] b;
    static int[] order;

    static ArrayList<Integer> dfs_order = new ArrayList<>();

    static void dfs(int x) {
        if (check[x] == true) {
            return;
        }
        dfs_order.add(x);
        check[x] = true;

        for (int y : a[x]) {
            if (check[y] == false) {
                dfs(y);
            }
        }

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        a = new ArrayList[n]; b = new int[n];
        order = new int[n]; check = new boolean[n];

        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt()-1; int v = sc.nextInt()-1;
            a[u].add(v); a[v].add(u);
        }

        for (int i=0; i<n; i++) {
            b[i] = sc.nextInt()-1;
            order[b[i]] = i;
        }

        for (int i=0; i<n; i++) {
            Collections.sort(a[i], new Comparator<Integer>() {

                public int compare(Integer u, Integer v) {
                    if (order[u] < order[v]) {
                        return -1;
                    } else if (order[u] == order[v]) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }

        dfs(0);

        boolean ok = true;
        for (int i=0; i<n; i++) {
            if (b[i] != dfs_order.get(i)) {
                ok = false;
            }
        }

        if (ok) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }
}