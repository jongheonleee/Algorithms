import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] a = new int[n], d = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            d[i] = a[i];
            for (int j=0; j<i; j++) {
                if (a[j]<a[i] && d[i]<a[i]+d[j]) {
                    d[i] = a[i]+d[j];
                }
            }
            if (result < d[i]) result = d[i];
        }

        System.out.println(result);

    }
}