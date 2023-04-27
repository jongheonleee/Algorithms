import java.io.*;
import java.util.*;
public class Main {

    static StringBuilder sb = new StringBuilder();

    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i>0 && a[i]<=a[i-1]) i--;

        if (i<=0) return false;

        int j = a.length-1;
        while (a[i-1]>=a[j]) j--;
        int tmp = a[i-1];
        a[i-1]=a[j]; a[j]=tmp;

        j = a.length-1;
        while (i<j) {
            tmp = a[j];
            a[j]=a[i]; a[i]=tmp;
            i++; j--;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n==0) break;
            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = sc.nextInt();

            int[] d = new int[n];
            for (int i=0; i<n; i++) {
                if (i<n-6) d[i] = 0;
                else d[i] = 1;
            }

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i=0; i<n; i++) {
                    if (d[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                ans.add(cur);
            } while(next_permutation(d));

            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                    int n = l1.size(), m = l2.size(), i=0;
                    while (i<n && i<m) {
                        int t1 = l1.get(i), t2 = l2.get(i);

                        if (t1 < t2) return -1;
                        else if(t1 > t2) return 1;
                        i++;
                    }
                    if (i==n && i!=m) return -1;
                    else if (i!=n && i==m) return 1;
                    return 0;
                }
            });

            for (ArrayList<Integer> v : ans) {
                for (int x : v) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}