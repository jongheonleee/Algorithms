import java.util.*;
import java.io.*;

public class Main {


    static int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length+ right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) ans[k++] = left[i++];
            else ans[k++] = right[j++];
        }

        while (i < left.length) ans[k++] = left[i++];
        while (j < right.length) ans[k++] = right[j++];

        return ans;
    }

    static int[] merge_sort(int[] a, int start, int end){
        if (start == end) {
            int[] tmp = new int[1];
            tmp[0] = a[start];
            return tmp;
        }

        int mid = (start+end)/2;
        int[] left = merge_sort(a, start, mid);
        int[] right = merge_sort(a, mid+1, end);

        return merge(left, right);
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());
        int[] ans = merge_sort(a, 0, n-1);
        for (int i=0; i<n; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }
}