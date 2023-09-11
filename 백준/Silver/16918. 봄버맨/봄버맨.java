import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        char[][] map = new char[r][c];
        for (int i=0; i<r; i++) {
            String line = br.readLine();
            for (int j=0; j<c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        // 0초 후 -> 기존에 설치된 폭탄 담기
        for (int x=0; x<r; x++) {
            for (int y=0; y<c; y++) {
                if (map[x][y] == 'O') {
                    q.add(new Pair(x, y));
                }
            }
        }

        n -= 1;
        if (n == 0) {
            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        while (true) {
            // 1초 후 -> 나머지 부분에 폭탄을 설칠함
            for (int x=0; x<r; x++) {
                for (int y=0; y<c; y++) {
                    if (map[x][y] == '.') {
                        map[x][y] = 'O';
                    }
                }
            }
            n -= 1;
            if (n == 0) break;

            // 2초 후 -> 기존에 설치한 폭탄을 터트림
            while (!q.isEmpty()) {
                Pair p = q.remove();
                int x = p.x;
                int y = p.y;

                map[x][y] = '.';

                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                        map[nx][ny] = '.';
                    }
                }
            }

            n -= 1;
            if (n == 0) break;

            for (int x=0; x<r; x++) {
                for (int y=0; y<c; y++) {
                    if (map[x][y] == 'O') {
                        q.add(new Pair(x, y));
                    }
                }
            }
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}