import java.util.*;
import java.io.*;


public class Main {

    static int[] count = new int[3]; // 0 -> -1, 1 -> 0, 2 -> 1

    static int[][] paper;


    static boolean isSameNumber(int x1, int y1, int x2, int y2) {
        int number = paper[x1][y1];

        for (int i=x1; i<=x2; i++) {
            for (int j=y1; j<=y2; j++) {
                if (number != paper[i][j]) return false;
            }
        }

        return true;
    }

    static void divide(int x, int y, int len) {
        if (len == 1 || isSameNumber(x, y, x+len-1, y+len-1)) {
            count[paper[x][y] + 1] += 1;
            return;
        } else {
            int m = len/3;

            // divide
            for (int k=0; k<3; k++) {
                divide(x+m*k, y, m);
                divide(x+m*k, y+m, m);
                divide(x+m*k, y+2*m, m);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }

        divide(0, 0, n);

        for (int i=0; i<3; i++) {
            System.out.println(count[i]);
        }
    }
}