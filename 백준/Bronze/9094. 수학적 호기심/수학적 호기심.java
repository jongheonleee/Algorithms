import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ts = Integer.parseInt(br.readLine());

        while (ts-- > 0) {
            String[] line = br.readLine().split(" ");
            int count = 0;
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            for (int a=1; a<n; a++) {
                for (int b=a+1; b<n; b++) {
                    if ((a*a + b*b + m)%(a*b) == 0) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
