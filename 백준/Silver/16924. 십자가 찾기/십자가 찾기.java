import java.io.*;
import java.util.*;

public class Main {

    static final int IMPOSSIBLE = -1;
    static char[][] a;
    static boolean[][] check;
    static int go(int x, int y) {
        int size = 0, len = 1;

        while (true) {
            int x1 = x+len, y1 = y;
            int x2 = x-len, y2 = y;
            int x3 = x, y3 = y+len;
            int x4 = x, y4 = y-len;

            if (0 > x-len || x+len >= a.length || 0 > y-len || y+len >= a[0].length) break;
            if (!(a[x1][y1] == '*' && a[x2][y2] == '*' && a[x3][y3] == '*' && a[x4][y4] == '*')) break;

            len++; size++;
        }


        return size;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new char[n][m];
        check = new boolean[n][m];

        for (int i=0; i<n; i++) {
            a[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == '*') {
                    int size = go(i, j);

                    if (size > 0) {
                        check[i][j] = true;

                        while (size>0) {
                            check[i+size][j] = true;
                            check[i][j+size] = true;
                            check[i-size][j] = true;
                            check[i][j-size] = true;
                            sb.append(i+1).append(" ").append(j+1).append(" ").append(size).append("\n");
                            ans++;
                            size--;
                        }
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == '*' && check[i][j] == false) {
                    System.out.println(IMPOSSIBLE);
                    System.exit(0);
                }
            }
        }

        System.out.println(ans);
        System.out.println(sb);
    }
}