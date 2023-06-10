import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static final int LIMIT = 1500;

    static boolean[][] check = new boolean[LIMIT+1][LIMIT+1];
    
    static int sum = 0;

    static void go(int x, int y) {
        if (check[x][y] == true) {
            return;
        }
        
        check[x][y] = true;
        int[] rocks = {x, y, sum-(x+y)};
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (rocks[i] < rocks[j]) {
                    int[] tmp = {x, y, sum-(x+y)};
                    tmp[i] += rocks[i];
                    tmp[j] -= rocks[i];
                    go(tmp[0], tmp[1]);
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        sum = a + b + c;
        if (sum % 3 != 0) {
            System.out.println(0);
            System.exit(0);
        }

        go(a, b);
        
        if (check[sum/3][sum/3] == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        System.exit(0);

    }
}