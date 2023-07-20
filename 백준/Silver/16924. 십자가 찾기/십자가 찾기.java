import java.io.*;
import java.util.*;


public class Main {

    static final int IMPOSSIBLE = -1;

    static char[][] a;
    static boolean[][] check;
    static boolean isValidRange(int x, int y) {
        if (0 <= x && x < a.length && 0 <= y && y < a[0].length) return true;
        return false;
    }

    static int moveUp(int x, int y, int len) {
        if (!isValidRange(x, y) || a[x][y] == '.') return len;
        return moveUp(x-1, y, len+1);
    }

    static int moveDown(int x, int y, int len) {
        if (!isValidRange(x, y) || a[x][y] == '.') return len;
        return moveDown(x+1, y, len+1);
    }

    static int moveLeft(int x, int y, int len) {
        if (!isValidRange(x, y) || a[x][y] == '.') return len;
        return moveLeft(x, y-1, len+1);
    }

    static int moveRight(int x, int y, int len) {
        if (!isValidRange(x, y) || a[x][y] == '.')return len;
        return moveRight(x, y+1, len+1);
    }
    static int go(int x, int y) {
        int lenUp = moveUp(x-1, y, 0);
        int lenDown = moveDown(x+1, y, 0);
        int lenLeft = moveLeft(x, y-1, 0);
        int lenRight = moveRight(x, y+1, 0);

        int[] tmp = {lenUp, lenDown, lenLeft, lenRight};
        Arrays.sort(tmp);
        return tmp[0];
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
            String line = br.readLine();
            a[i] = line.toCharArray();
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == '*' ) {
                    int size = go(i, j);
                    cnt += size;
                    while (size > 0) {
                        sb.append(i+1).append(" ").append(j+1)
                                .append(" ").append(size).append("\n");
                        check[i][j] = true;
                        check[i-size][j] = true;
                        check[i][j+size] = true;
                        check[i][j-size] = true;
                        check[i+size][j] = true;
                        size--;
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

        System.out.println(cnt);
        System.out.println(sb);


    }
}