import java.util.*;
import java.io.*;




public class Main {

    static void show(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void merge(int[] a, int ls, int le, int rs, int re) {
        int[] tmp = new int[(le-ls+1) + (re-rs+1)];
        int i = ls, j = rs, k = 0;

        while (i < rs && j < re+1) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else tmp[k++] = a[j++];
        }

        while (i<rs) tmp[k++] = a[i++];
        while (j<re+1) tmp[k++] = a[j++];

        for (int z=ls; z<=re; z++) {
            a[z] = tmp[z-ls];
        }
    }

    static void merge_sort(int[] a, int start, int end) {
        if (start == end) return;

        int mid = start + (end-start)/2;
        merge_sort(a, start, mid);
        merge_sort(a, mid+1, end);
        merge(a, start, mid, mid+1, end);
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());
        merge_sort(a, 0, n-1);
        show(a);

    }
}