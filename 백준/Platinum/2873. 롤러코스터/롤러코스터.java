import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void append(StringBuilder sb, char dir, int cnt) {
        for (int i=0; i<cnt; i++) {
            sb.append(dir);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        for (int i=0; i<r; i++) {
            String[] line = br.readLine().split(" ");

            for (int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 모든 칸을 방문할 수 있는 경우 1
        if (r % 2 == 1) {
            for (int i=0; i<r; i++) {
                if (i%2 == 0) {
                    append(sb, 'R', c-1);
                    if (i != r-1) {
                        append(sb, 'D', 1);
                    }
                }
                else {
                    append(sb, 'L', c-1);
                    append(sb, 'D', 1);
                }
            }
        }
        // 모든 칸을 방문할 수 있는 경우 2
        else if (c % 2 == 1) {
            for (int j=0; j<c; j++) {
                if (j%2 == 0) {
                    append(sb, 'D', r-1);
                    if (j != c-1) {
                        append(sb, 'R', 1);
                    }
                } else {
                    append(sb, 'U', r-1);
                    append(sb, 'R', 1);
                }
            }
        }
        // 모든 칸을 방문하는 것이 불가능할 때
        else {
            int x, y;
            x = 0; y = 1;

            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    if ((i+j) % 2 == 1) {
                        if (map[x][y] > map[i][j]) {
                            x = i; y = j;
                        }
                    }
                }
            }

            int x1 = 0, y1 = 0;
            int x2 = r-1, y2 = c-1;

            StringBuilder sb2 = new StringBuilder();

            while (x2 - x1 > 1) {
                if (x1/2 < x/2) {
                    append(sb, 'R', c-1);
                    append(sb, 'D', 1);
                    append(sb, 'L', c-1);
                    append(sb, 'D', 1);

                    x1 += 2;
                }

                if (x/2 < x2/2) {
                    append(sb2, 'R', c-1);
                    append(sb2, 'D', 1);
                    append(sb2, 'L', c-1);
                    append(sb2, 'D', 1);

                    x2 -= 2;
                }
            }

            while (y2 - y1 > 1) {
                if (y1/2 < y/2) {
                    append(sb, 'D', 1);
                    append(sb, 'R', 1);
                    append(sb, 'U', 1);
                    append(sb, 'R', 1);

                    y1 += 2;
                }

                if (y/2 < y2/2) {
                    append(sb2, 'D', 1);
                    append(sb2, 'R', 1);
                    append(sb2, 'U', 1);
                    append(sb2, 'R', 1);

                    y2 -= 2;
                }
            }

            if (y == y1) {
                append(sb, 'R', 1);
                append(sb, 'D', 1);
            } else {
                append(sb, 'D', 1);
                append(sb, 'R', 1);
            }

            sb2.reverse();
            sb.append(sb2);
        }

        System.out.println(sb);
    }
}