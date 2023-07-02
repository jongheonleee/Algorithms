import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final char STAR = '*';
    static final char BLANK = ' ';

    static void go(char[][] a, int x, int y, int size, char color) {
        if (color == BLANK) {
            for (int i=x; i<x+size; i++) {
                for (int j=y; j<y+size; j++) {
                    a[i][j] = BLANK;
                }
            }
        }

        else {
            if (size == 1) {
                a[x][y] = color;
            }

            else {
                int m = size/3;

                char newColor = STAR;
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        if (i == 1 && j == 1) {
                            newColor = BLANK;
                        }
                        else {
                            newColor = STAR;
                        }
                        go(a, x+m*i, y+m*j, m, newColor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] a = new char[n][n];

        go(a, 0, 0, n, STAR);
        for (int i=0; i<n; i++) {
            System.out.println(String.valueOf(a[i]));
        }

    }
}