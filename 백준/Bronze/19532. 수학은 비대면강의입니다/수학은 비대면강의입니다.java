import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int[] arr = new int[line.length];

        for (int i=0; i<line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        int min = -999, max = 999;
        int ansX = 0, ansY = 0;
        for (int x=min; x<=max; x++) {
            for (int y=min; y<=max; y++) {
                if ((arr[0] * x + arr[1] * y == arr[2])
                        && (arr[3] * x + arr[4] * y == arr[5])) {
                    ansX = x;
                    ansY = y;
                    break;
                }
            }
        }
        System.out.println(ansX + " " + ansY);
    }
}