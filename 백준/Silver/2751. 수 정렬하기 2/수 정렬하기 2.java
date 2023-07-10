import java.util.*;
import java.io.*;

public class Main {

    static void shuffle(int[] a){
        Random random = new Random();

        for (int i=a.length-1; i>0; i--) {
            int idx = random.nextInt(i+1);
            int tmp = a[idx];
            a[idx] = a[i];
            a[i] = tmp;
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());
        shuffle(a);
        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            bw.write(a[i] + "\n");
        }
        bw.flush();
    }
}