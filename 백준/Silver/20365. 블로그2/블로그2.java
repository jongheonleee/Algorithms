import java.util.*;
import java.io.*;



public class Main {



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int b = 0;
        int r = 0;
        
        if (line.charAt(0) == 'B') {
            b += 1;
        } else if (line.charAt(0) == 'R') {
            r += 1;
        }
        
        for (int i=1; i<n; i++) {
            if (line.charAt(i-1) != line.charAt(i)) {
                if (line.charAt(i) == 'B') {
                    b += 1;
                } else {
                    r += 1;
                }
            }
        }

        System.out.println(Math.min(b, r) + 1);

    }
}