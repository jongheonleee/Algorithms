import java.util.*;
import java.io.*;


public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        // i+j >= n-1
        for (int i=0; i<2*n-1; i++) {
            for (int j=0; j<n; j++) {
                if ((i < n && i+j >= n-1) || (i>=n && i-j<n)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}