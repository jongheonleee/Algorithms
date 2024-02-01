import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] numbers = new int[n];

        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(numbers);

       if (n > 2) {
           int ans = 2;
           for (int i=0; i<n-2; i++) {
               int j = i+2;
               while (j < n && (numbers[i] + numbers[i+1] > numbers[j])) {
                   ans = ans > j-i+1 ? ans : j-i+1;
                   j++;
               }
           }
           System.out.println(ans);
       } else {
           System.out.println(n);
       }

   }
}