import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int ans = 0;

    static char[][] a;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new char[n][n];

        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<n; j++) {
                a[i][j] = line.charAt(j);
            }
        }

        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                // 스왑하지 않은 경우
                calculateRow(x, y);
                calculateColumn(x, y);
                
                // 스왑을 한 경우
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k]; int ny = y+dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (a[x][y] != a[nx][ny]) {
                            swap(x, y, nx, ny);
                            calculateRow(x, y);
                            calculateColumn(x, y);
                            swap(x, y, nx, ny);
                        }
                    }
                }
            }
        }

        System.out.println(ans);

    }

    static void swap(int x, int y, int nx, int ny) {
        char tmp = a[x][y];
        a[x][y] = a[nx][ny];
        a[nx][ny] = tmp;
    }

    static void calculateRow(int x, int y) {
        int len = 0;
        for (int i=x; i>=0; i--) {
            if (a[x][y] == a[i][y]) len++;
            else break;
        }

        for (int i=x; i<a.length; i++) {
            if (a[x][y] == a[i][y]) len++;
            else break;
        }
        len--;

        if (ans < len) {
            ans = len;
        }
    }

    static void calculateColumn(int x, int y) {
        int len = 0;
        for (int i=y; i>=0; i--) {
            if (a[x][y] == a[x][i]) len++;
            else break;
        }

        for (int i=y; i<a[0].length; i++) {
            if (a[x][y] == a[x][i]) len++;
            else break;
        }
        len--;

        if (ans < len) {
            ans = len;
        }
    }
}