import java.io.*;
import java.util.*;

public class Main {

    static int a = 0; // -1
    static int b = 0; // 0
    static int c = 0; // 1

    static int[][] paper;
    // divide paper
    public static void go(int x1, int y1, int x2, int y2) {
        if (!checkRange(x1, y1) || !checkRange(x2, y2)) return;

        if (check(x1, y1, x2, y2)) {
            if (paper[x1][y1] == -1) {
                a++;
            } else if (paper[x1][y1] == 0) {
                b++;
            } else {
                // paper[x1][y1] == 1
                c++;
            }
        }
        else {
            // divide
            int n = (x2-x1+1)/3;
            int m = (y2-y1+1)/3;

            for (int i=x1; i<x1+3*n; i+=n) {
                for (int j=y1; j<y1+3*m; j+=m) {
                    go(i, j, i+n-1, j+m-1);
                }
            }
        }
    }

    public static boolean check(int x1, int y1, int x2, int y2) {
        int mark = paper[x1][y1];

        for (int i=x1; i<=x2; i++) {
            for (int j=y1; j<=y2; j++)
                if (mark != paper[i][j]) return false;
        }

        return true;
    }

    public static boolean checkRange(int x, int y) {
        if ((0 <= x && x <= paper.length-1 && 0 <= y && y <= paper[0].length)){
            return true;
        }
        else {
            return true;
        }
    }


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }

        go(0, 0, n-1, n-1);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}