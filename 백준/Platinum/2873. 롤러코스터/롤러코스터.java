import java.io.*;
import java.util.*;

public class Main {

    static void append(StringBuilder sb, char ch, int cnt) {
        for (int i=0; i<cnt; i++) {
            sb.append(ch);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        StringBuilder sb1 = new StringBuilder();
        if (n % 2 == 1) {
            for (int i=0; i<n; i++) {
                if (i % 2 == 0) {
                    append(sb1, 'R', m-1);
                    if (i != n-1) {
                        append(sb1, 'D', 1);
                    }
                }
                else {
                    append(sb1, 'L', m-1);
                    append(sb1, 'D', 1);
                }
            }
        } else if (m % 2 == 1) {
            for (int j=0; j<m; j++) {
                if (j % 2 == 0) {
                    append(sb1, 'D', n-1);
                    if (j != m-1) {
                        append(sb1, 'R', 1);
                    }
                }
                else {
                    append(sb1, 'U', n-1);
                    append(sb1, 'R', 1);
                }
            }
        } else {
            int x=0, y=1;

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if ((i+j) % 2 == 1) {
                        if (map[x][y] > map[i][j]) {
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            int x1=0, y1=0;
            int x2=n-1, y2=m-1;

            StringBuilder sb2 = new StringBuilder();

            while (x2 - x1 > 1) {
                if (x1/2 < x/2) {
                    append(sb1, 'R', m-1);
                    append(sb1, 'D', 1);
                    append(sb1, 'L', m-1);
                    append(sb1, 'D', 1);

                    x1 += 2;
                }

                if (x2/2 > x/2) {
                    append(sb2, 'R', m-1);
                    append(sb2, 'D', 1);
                    append(sb2, 'L', m-1);
                    append(sb2, 'D', 1);

                    x2 -= 2;
                }
            }

            while (y2 - y1 > 1) {
                if (y1/2 < y/2) {
                    append(sb1, 'D', 1);
                    append(sb1, 'R', 1);
                    append(sb1, 'U', 1);
                    append(sb1, 'R', 1);

                    y1 += 2;
                }

                if (y2/2 > y/2) {
                    append(sb2, 'D', 1);
                    append(sb2, 'R', 1);
                    append(sb2, 'U', 1);
                    append(sb2, 'R', 1);

                    y2 -= 2;
                }
            }

            if (y == y1) {
                append(sb1, 'R', 1);
                append(sb1, 'D', 1);
            } else {
                append(sb1, 'D', 1);
                append(sb1, 'R', 1);
            }
            sb2.reverse();
            sb1.append(sb2);
        }

        System.out.println(sb1);
    }
}