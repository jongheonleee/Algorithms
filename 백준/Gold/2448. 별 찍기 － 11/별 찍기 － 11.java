import java.util.*;
import java.io.*;


public class Main {

    static final char STAR = '*';
    static final char BLANK = ' ';

    static char[][] paper;

    static void divide(int x, int y, int n, char color) {
        if (color == BLANK) {
            int m = 2*n-1;

            for (int i=x; i<x+n; i++) {
                for (int j=0; j<m; j++) {
                    paper[i][j+i-x+y] = BLANK;
                }
                m -= 2;
            }
        } else if (color == STAR) {
            if (n != 1) {
                int m = n/2;

                divide(x, y, m, STAR);
                divide(x+m, y-m, m, STAR);
                divide(x+m, y+m, m, STAR);

                if (n == 3) {
                    divide(x+1, y, 1, BLANK);
                }
                else {
                    divide(x+m, y-m+1, m, BLANK);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());

        paper = new char[n][2*n];
        for (int i=0; i<n; i++) {
            Arrays.fill(paper[i], STAR);
        }

        divide(0, n-1, n, STAR);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-i-1; j++) {
                paper[i][j] = BLANK;
                paper[i][2*n-j-2] = BLANK;
            }
            paper[i][2*n-1] = BLANK;
        }

        for (int i=0; i<n; i++) {
            System.out.println(String.valueOf(paper[i]));
        }

    }
}