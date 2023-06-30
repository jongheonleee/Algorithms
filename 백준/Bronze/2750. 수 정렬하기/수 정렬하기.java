import java.io.*;
import java.util.*;

public class Main {

    static int[] a;
    static int[] tmp;

    private static void merge(int start, int end) {
        int mid = (start + end) /2;
        int i = start, j = mid+1, k = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }

        while (i <= mid) tmp[k++] = a[i++];
        while (j <= end) tmp[k++] = a[j++];

        for (int z=start; z<=end; z++) {
            a[z] = tmp[z-start];
        }
    }
    private static void merge_sort(int start, int end) {
        if (start == end) return;

        int mid = (start+end)/2;
        merge_sort(start, mid);
        merge_sort(mid+1, end);
        merge(start, end);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        a = new int[n];
        tmp = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(0, n-1);

        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
    }
}