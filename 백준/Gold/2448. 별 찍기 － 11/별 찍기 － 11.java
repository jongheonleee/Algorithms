import java.io.*;
import java.util.*;

public class Main {

    static final char STAR = '*';
    static final char BLANK = ' ';

    static void go(char[][] a, int x, int y, int n, char color) {
        if (color == BLANK) {
            int m = 2*n-1;
            for (int i=x; i<x+n; i++) {
                for (int j=0; j<m; j++) {
                    a[i][j+y+i-x] = BLANK;
                }
                m -= 2;
            }
        }
        else {

            if (n != 1) {
                int m = n/2;

                go(a, x, y, m, color);
                go(a, x+m, y-m, m, color);
                go(a, x+m, y+m, m, color);

                if (n == 3) {
                    go(a, x+1, y, 1, BLANK);
                }
                else {
                    go(a, x+m, y-m+1, m, BLANK);
                }
            }

        }


    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] a = new char[n][2*n];

        for (int i=0; i<n; i++) {
            Arrays.fill(a[i], STAR);
        }

        go(a, 0, n-1, n, STAR);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-i-1; j++) {
                a[i][j] = BLANK;
                a[i][2*n-j-2] = BLANK;
            }
            a[i][2*n-1] = BLANK;
        }


        for (int i=0; i<n; i++) {
            System.out.println(String.valueOf(a[i]));
        }
    }
}