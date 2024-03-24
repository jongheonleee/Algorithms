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

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


/**
 *
 *   지도를 입력하여 단지수를 출력하고,
 *   각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 *
 **/
public class Main {

    /**
     // 0. 입력 처리 및 기본 구현
         // 1. 지도 순회
             // 1-0. 지도의 값이 1이고 단지수 0인 경우
                 // 1-0-0. bfs 적용 및 연결된 부분 단지수 기록

         // 1-1. 그렇지 않은 경우, 스킵

         // 2. 각 단지의 집의 수 계산
             // 리스트에 담으면서 마지막엔 오름차순 정렬

         // 3. 결과 출력
             // 전체 단지 수와 각 단지의 집의 수 오름차순 출력

     *
     *
     **/

    static int n;
    static int[][] map, numbers;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        numbers = new int[n][n];

        for (int i=0; i<n; i++) {
            String line = br.readLine();

            for (int j=0; j<n; j++) {
                map[i][j] = line.charAt(j) - '0';
                numbers[i][j] = 0;
            }
        }
    }
    private static int findEachSrcAndStartBfs(int number) {
        for (int i=0; i<n; i++) {
            for (int j=0;  j<n; j++) {
                if (map[i][j] == 1 && numbers[i][j] == 0) {
                    Point src = new Point(i, j);
                    bfs(src, number);
                    number++;
                }
            }
        }

        return number-1;
    }

    private static void bfs(Point src, int number) {
        Queue<Point> q = new LinkedList<>();
        q.add(src);
        numbers[src.x][src.y] = number;

        while (!q.isEmpty()) {
            Point curr = q.remove();
            int x = curr.x;
            int y = curr.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (!(0 <= nx && nx < n && 0 <= ny && ny < n)) continue;
                if (map[nx][ny] == 0) continue;
                if (numbers[nx][ny] != 0) continue;

                Point next = new Point(nx, ny);
                q.add(next);
                numbers[nx][ny] = number;
            }
        }

    }

    private static int[] countEachNumberOfHouse(int numberOfGroup) {
        int[] eachNumberOfHouse = new int[numberOfGroup];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (numbers[i][j] != 0) {
                    int group = numbers[i][j];
                    eachNumberOfHouse[group-1]++;
                }
            }
        }

        Arrays.sort(eachNumberOfHouse);
        return eachNumberOfHouse;

    }



    private static void printResult(int numberOfGroup, int[] eachNumberOfHouse) {
        StringBuilder sb = new StringBuilder();

        sb.append(numberOfGroup).append("\n");
        for (int numberOfHouse : eachNumberOfHouse) {
            sb.append(numberOfHouse).append("\n");
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        setUp();
        int numberOfGroup = findEachSrcAndStartBfs(1);
        int[] eachNumberOfHouse = countEachNumberOfHouse(numberOfGroup);
        printResult(numberOfGroup, eachNumberOfHouse);
    }
}