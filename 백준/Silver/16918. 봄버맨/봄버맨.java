import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;




/**
  폭탄이 있던 칸이 (i, j)인 경우에 (i+1, j), (i-1, j), (i, j+1), (i, j-1)도 함께 파괴
  연쇄 반응은 없다.
  - 1. 봄버맨은 일부 칸에 폭탄을 설치해 놓음
  - 2. 다음 1초 동안 봄버맨은 아무것도 하지 않음
  - 3. 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치
  - 4. 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발
  - 3과 4를 반복
  빈 칸은 '.'로, 폭탄은 'O', N초가 지난 후의 격자판 상태를 출력
 **/
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    /**

     BFS, 시뮬레이션 적용
     시간 단위로 폭탄 설치 및 bfs의 큐에 담기
     3 초전 폭탄을 큐에 담고 터트리는 과정 반복, 주어진 시간이 다 소모될 때까지 시뮬레이션 돌리기
     결과 출력

     **/

    static int n, m, s;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static Queue<Point> q;

    private static void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");

        n = Integer.parseInt(numbers[0]);
        m = Integer.parseInt(numbers[1]);
        s = Integer.parseInt(numbers[2]);

        map = new char[n][m];
        q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
    }

    private static void simulate() {
        // second가 s가 될때까지 반복
            // second가 홀수인 경우 폭탄 설치
            // second가 짝수인 경우 폭탄 터트림
        if (s == 1) return;

        int second = 1;
        while (second < s) {
            if (second % 2 != 0) {
                plantBombs();
            } else {
                bfs();
            }
            second++;
        }
    }

    private static void plantBombs() {
        // 기존에 폭탄 큐에 담기
        // 폭탄 설치가 안된 부분 설치
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 'O') {
                    q.add(new Point(i, j));
                } else {
                    map[i][j] = 'O';
                }
            }
        }

    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Point curr = q.remove();

            int x = curr.x;
            int y = curr.y;
            map[x][y] = '.';

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (!(0 <= nx && nx < n && 0 <= ny && ny < m)) continue;
                map[nx][ny] = '.';
            }
        }
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


    // 0. 맵 구현 및 기본 값 설정

    // 1. 시뮬레이션 0초 될 때까지 돌리기
        // 주어진 시간에 맞게 시뮬레이션 돌림
        // 1초 : 아무것도 안함
        // 2초 : 폭탄 설치(폭탄 설치하기 전에 기존의 폭탄 큐에 담기)
        // 3초 : 폭탄 터트림
        // 4초 : 폭탄 설치(폭탄 설치하기 전에 기존의 폭탄 큐에 담기)
        // 5초 : 폭탄 터트림
        // ,,,
        // 폭탄 터트리는 과정 bfs

    // 2. 결과 출력
    public static void main(String[] args) throws IOException {
        // 0. 맵 구현 및 기본 값 설정
        // 1. 시뮬레이션 0초 될 때까지 돌리기
        // 2. 결과 출력
        setUp();
        simulate();
        printMap();

    }
}