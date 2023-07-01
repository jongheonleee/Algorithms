import java.io.*;
import java.util.*;

public class Main {
    
    static int power2(int k) {
        return (1 << k);
    }
    
    static int solve(int n, int x, int y) {
        if (n == 1) {
            return 2*x+y;
        }
        else {
            if (x < power2(n-1)) {
                if (y < power2(n-1)) {
                    return solve(n-1, x, y);
                }
                else {
                    return solve(n-1, x, y-power2(n-1)) + power2(2*(n-1));
                }
            }
            
            else {
                if (y < power2(n-1)) {
                    return solve(n-1, x-power2(n-1), y) + power2(2*(n-1)) * 2;
                }
                else {
                    return solve(n-1, x-power2(n-1), y-power2(n-1)) + power2(2*(n-1)) * 3;
                }
            }
        }
        
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        
        int n = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        System.out.println(solve(n, r, c));


    }
}