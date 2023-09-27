import java.util.*;
import java.io.*;



public class Main {

    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(); int c = sc.nextInt();
        int[][] mirror = new int[r+1][c+1];
        int[][] dp = new int [r+1][c+1];
        for (int i=1; i<r+1; i++) {
            for (int j=1; j<c+1; j++) {
                mirror[i][j] = sc.nextInt();
            }
        }

        for (int i=1; i<r+1; i++) {
            for (int j=1; j<c+1; j++) {
                dp[i][j] = mirror[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[r][c]);
     }
}