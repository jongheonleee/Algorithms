import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] a = new int[n], d = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        for (int i=0; i<n; i++) {
            d[i] = 1;
            for (int j=0; j<i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
            
            result = result > d[i] ? result : d[i];
        }

        System.out.println(result);
    }
}