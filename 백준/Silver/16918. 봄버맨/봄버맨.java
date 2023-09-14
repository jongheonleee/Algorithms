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
 * 큐에 기존에 설치된 폭탄을 터트리는 방식
 */
public class Main {
    static int row, col;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map;

    // 봄버맨의 행동 실행
    static void simulate(int second) {
        Queue<Pair> q = new LinkedList<>();
        // 기존에 설치된 폭탄 큐에 담기
        for (int x=0; x<row; x++) {
            for (int y=0; y<col; y++) {
                if (map[x][y] == 'O') {
                    q.add(new Pair(x, y));
                }
            }
        }

        while (true) {
            // 2초 후 -> 나머지 부분에 폭탄을 설치함
            // "다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다"
            for (int x=0; x<row; x++) {
                for (int y=0; y<col; y++) {
                    if (map[x][y] == '.') {
                        map[x][y] = 'O';
                    }
                }
            }
            second -= 1;
            if (second == 0) break;

            // 3초 후 -> 기존에 설치한 폭탄을 터트림
            // "1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다."
            while (!q.isEmpty()) {
                Pair p = q.remove();
                int x = p.x;
                int y = p.y;

                map[x][y] = '.';

                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if (0 <= nx && nx < row && 0 <= ny && ny < col) {
                        map[nx][ny] = '.';
                    }
                }
            }
            second -= 1;
            if (second == 0) break;

            // "3과 4를 반복한다."
            // 그 다음 과정을 위해서 남아있는 폭탄을 큐에 담아줌
            for (int x=0; x<row; x++) {
                for (int y=0; y<col; y++) {
                    if (map[x][y] == 'O') {
                        q.add(new Pair(x, y));
                    }
                }
            }
        }
    }

    // map을 출력해줌
    static void show() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        int second = Integer.parseInt(input[2]);

        // 입력값을 통해서 지도 구현
        map = new char[row][col];
        for (int i=0; i<row; i++) {
            String line = br.readLine();
            for (int j=0; j<col; j++) {
                map[i][j] = line.charAt(j);
            }
        }


        // "다음 1초 동안 봄버맨은 아무것도 하지 않는다."
        second -= 1;
        if (second == 0) {
            show();
            System.exit(0);
        }

        simulate(second); // n초 동안 봄버맨 실행시키기
        show(); // n 초 이후에 map 출력하기

    }
}