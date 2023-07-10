import java.util.*;
import java.io.*;



public class Main {

    static void shuffle(int[] a) {
        Random random = new Random();
        for (int i=a.length-1; i<=0; i--) {
            int index = random.nextInt(i+1);
            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
        }
    }



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());
        shuffle(a);
        Arrays.sort(a);
        for (int e : a) {
            sb.append(e).append("\n");
        }
        System.out.println(sb);
    }
}