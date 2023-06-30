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

    private static int choosePivot(int low, int high) {
        return (low+high)/2;
    }

    private static int partition(int low, int high) {
        int pivotIdx = choosePivot(low, high);
        int pivotVal = a[pivotIdx];

        swap(pivotIdx, high);

        int storeIdx = low;
        for (int i=low; i<high; i++) {
            if (a[i] < pivotVal) {
                swap(i, storeIdx);
                storeIdx++;
            }
        }

        swap(storeIdx, high);
        return storeIdx;

    }

    private static void quickSort(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);
            quickSort(low, pivot-1);
            quickSort(pivot+1, high);
        }
    }

    private static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        a = new int[n];
        tmp = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
//        merge_sort(0, n-1);

        quickSort(0, n-1);

        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
    }
}