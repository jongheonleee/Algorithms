import java.util.*;
import java.io.*;



public class Main {

    static int n, m;
    static char[][] map;
    static boolean[][] check;

    static boolean isValid(int x, int y, int len) {
//        System.out.println("x = " + x + " y = " + y + " len = " + len);
        if (0 <= x-len && x+len < n &&
            0 <= y-len && y+len < m ) {
            if (map[x-len][y] == '#' && check[x-len][y] == false &&
                map[x+len][y] == '#' && check[x+len][y] == false &&
                map[x][y-len] == '#' && check[x][y-len] == false &&
                map[x][y+len] == '#' && check[x][y+len] == false) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        check = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                char ch = line.charAt(j);
                map[i][j] = ch;
                if (ch == '.') check[i][j] = true;
            }
        }

        int ans = 0;
        for (int x1=0; x1<n; x1++) {
            for (int y1=0; y1<m; y1++) {
                if (map[x1][y1] == '#' && check[x1][y1] == false) {
                    // make s1
                    int len1 = 0;
                    while (isValid(x1, y1, len1)) {
                        // s1
                        check[x1-len1][y1] = true;
                        check[x1+len1][y1] = true;
                        check[x1][y1-len1] = true;
                        check[x1][y1+len1] = true;
                        len1++;

                        for (int x2=0; x2<n; x2++) {
                            for (int y2=0; y2<m; y2++) {
                                if (map[x2][y2] == '#' && check[x2][y2] == false) {
                                    // make s2
                                    int len2 = 0;
                                    while (isValid(x2, y2, len2)) {
                                        check[x2-len2][y2] = true;
                                        check[x2+len2][y2] = true;
                                        check[x2][y2-len2] = true;
                                        check[x2][y2+len2] = true;
                                        len2++;
                                    }

                                    int s1 = len1 > 0 ? (1+(len1-1)*4) : 1;
                                    int s2 = len2 > 0 ? (1+(len2-1)*4) : 1;
                                    if (ans < s1 * s2) ans = s1 * s2;


                                    // s2 초기화하기
                                    len2--;
                                    while (len2 >= 0) {
                                        check[x2-len2][y2] = false;
                                        check[x2+len2][y2] = false;
                                        check[x2][y2-len2] = false;
                                        check[x2][y2+len2] = false;
                                        len2--;
                                    }
                                }
                            }
                        }
                    }

                    len1--;
                    // s1 초기화하기
                    while (len1 >= 0) {
                        check[x1-len1][y1] = false;
                        check[x1+len1][y1] = false;
                        check[x1][y1-len1] = false;
                        check[x1][y1+len1] = false;
                        len1--;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}