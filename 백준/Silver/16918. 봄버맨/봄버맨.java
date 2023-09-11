import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


/**
 * 만약, 폭탄이 폭발했을 때, 인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다.
 * 따라서, 연쇄 반응은 없다.
 */
public class Main {
    static int r, c, n;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static char[][] map;
    
    static void simulate() {
        Queue<Pair> q = new LinkedList<>();
        // 기존에 설치된 폭탄 큐에 담기
        for (int x=0; x<r; x++) {
            for (int y=0; y<c; y++) {
                if (map[x][y] == 'O') {
                    q.add(new Pair(x, y));
                }
            }
        }
        
        while (true) {
            // 1초 후 -> 나머지 부분에 폭탄을 설칠함
            // "다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다"
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
            // "1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다."
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

            // "3과 4를 반복한다."
            // 따라서, 그 다음 과정을 위해서 폭탄을 담아줌
            for (int x=0; x<r; x++) {
                for (int y=0; y<c; y++) {
                    if (map[x][y] == 'O') {
                        q.add(new Pair(x, y));
                    }
                }
            }
        }
    }
    
    static void show() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        n = Integer.parseInt(input[2]);

        // 입력값을 통해서 지도 구현
        map = new char[r][c];
        for (int i=0; i<r; i++) {
            String line = br.readLine();
            for (int j=0; j<c; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        

        // "다음 1초 동안 봄버맨은 아무것도 하지 않는다."
        n -= 1;
        if (n == 0) {
            show();
            System.exit(0);
        }

        simulate();
        show();

    }
}