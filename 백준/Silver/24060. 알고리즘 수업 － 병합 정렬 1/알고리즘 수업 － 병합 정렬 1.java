import java.io.*;
import java.util.*;

public class Main {

    static final int IMPOSSIBLE = -1;

    static int cnt = 0;
    static int n;
    static int k;
    static int[] a;
    static int[] tmp;
    static void merge(int start, int end) {
        int mid = (start+end)/2;
        int i=start, j=mid+1, z=0;
        
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) tmp[z++] = a[i++];
            else tmp[z++] = a[j++];
        }

        while (i <= mid) tmp[z++] = a[i++];
        while (j <= end) tmp[z++] = a[j++];

        for (int t=start; t<=end; t++) {
            cnt++;
            a[t] = tmp[t-start];
            if (cnt == k) {
                System.out.println(a[t]);
                System.exit(0);
            }
        }
    }

    static void merge_sort(int start, int end) {
        if (start == end) return;

        int mid = (start+end)/2;
        merge_sort(start, mid);
        merge_sort(mid+1, end);
        merge(start, end);

    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        tmp = new int[n];

        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        merge_sort(0, n-1);

        if (cnt < k) {
            System.out.println(IMPOSSIBLE);
        }
    }
}