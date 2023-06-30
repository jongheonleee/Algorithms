import java.io.*;
import java.util.*;

public class Main {

    static int[] a;

    static void quick_sort(int low, int high) {
        if (low < high) {
            int pivotIdx = partition(low, high);
            quick_sort(low, pivotIdx-1);
            quick_sort(pivotIdx+1, high);
        }
    }

    static int partition(int low, int high) {
        int pivotIdx = choosePivot(low, high);
        int pivotVal = a[pivotIdx];

        swap(pivotIdx, high);

        int storeIdx = low;
        for (int i=low; i<high; i++) {
            if (a[i] < pivotVal) {
                swap(storeIdx, i);
                storeIdx++;
            }
        }
        swap(storeIdx, high);
        return storeIdx;
    }

    static int choosePivot(int low, int high) {
        return (low+high)/2;
    }

    static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        quick_sort(0, n-1);

        for (int num : a) {
            System.out.println(num);
        }

    }
}