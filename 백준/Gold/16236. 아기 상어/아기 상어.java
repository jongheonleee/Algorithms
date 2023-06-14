import java.util.*;
import java.io.*;

/**
 * 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
 * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다. -> dfs/bfs
 * 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다. -> bfs
 * 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다. ->
 * 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 */
class Fish {
    int x, y, dist;

    Fish(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {


    static int n;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean can(int x, int y, int[][] dist) {
        return (0 <= x && x < n && 0 <= y && y < n) && dist[x][y] == -1;
    }

    private static Fish bfs(int[][] sea, int sx, int sy, int size) {
        int[][] dist = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dist[i][j] = -1;
            }
        }

        ArrayList<Fish> eatableFishes = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy));
        dist[sx][sy] = 0;

        while (!(q.isEmpty())) {
            Pair p = q.remove();

            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (can(nx, ny, dist) == false) continue;
                boolean move = false;
                boolean eat = false;
                // 이동만 가능한 경우
                if (sea[nx][ny] == 0 || sea[nx][ny] == size) {
                    move = true;
                }
                // 이동할 수 있고 먹을수도 있는 경우
                else if (sea[nx][ny] < size) {
                    move = true;
                    eat = true;
                }

                if (move) {
                    q.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[x][y] + 1;

                    if (eat) {
                        eatableFishes.add(new Fish(nx, ny, dist[nx][ny]));
                    }
                }

            }
        }

        if (eatableFishes.size() == 0) return null;

        Fish eatenFish = eatableFishes.get(0);
        for (Fish fish : eatableFishes) {
            if (eatenFish.dist > fish.dist) {
                eatenFish = fish;
            } else if (eatenFish.dist == fish.dist && eatenFish.x > fish.x) {
                eatenFish = fish;
            } else if (eatenFish.dist == fish.dist && eatenFish.x == fish.x && eatenFish.y > fish.y) {
                eatenFish = fish;
            }
        }

        return eatenFish;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] sea = new int[n][n];

        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");

            for (int j=0; j<n; j++) {
                sea[i][j] = Integer.parseInt(input[j]);
            }
        }

        int babySharkX = 0;
        int babySharkY = 0;
        int babySharkSize = 2;
        int babySharkDist = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (sea[i][j] == 9) {
                    babySharkX = i;
                    babySharkY = j;
                    sea[babySharkX][babySharkY] = 0;
                }
            }
        }

        int eaten = 0;
        while (true) {
            Fish eatenFish = bfs(sea, babySharkX, babySharkY, babySharkSize);

            if (eatenFish == null) break;
            eaten++;
            sea[eatenFish.x][eatenFish.y] = 0;

            babySharkX = eatenFish.x;
            babySharkY = eatenFish.y;
            babySharkDist += eatenFish.dist;

            if (babySharkSize == eaten) {
                babySharkSize++;
                eaten = 0;
            }
        }

        System.out.println(babySharkDist);
    }
}