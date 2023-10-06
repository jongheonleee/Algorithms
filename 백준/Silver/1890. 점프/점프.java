import java.util.*;
import java.io.*;



public class Main {
    
    static final int LIMIT = 100;
    static int[][] jump = new int[LIMIT+1][LIMIT+1];
    static long[][] d = new long[LIMIT+1][LIMIT+1];


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                jump[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        d[0][0] = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 && j == 0) continue;
                
                for (int k=0; k<j; k++) {
                    if (k+jump[i][k] == j) {
                        d[i][j] += d[i][k];
                    }
                }
                
                for (int k=0; k<i; k++) {
                    if (k+jump[k][j] == i) {
                        d[i][j] += d[k][j];
                    }
                }
            }
        }
        System.out.println(d[n-1][n-1]);

    }
}