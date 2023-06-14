import java.util.*;
class Pair {
    // 아기 상어가 (x, y)에 있는 해당 물고기를 먹는데 걸린 시간(거리)
    int dist, x, y;
    Pair(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static Pair bfs(int[][] sea, int sx, int sy, int size) {
        int n = sea.length;
        ArrayList<Pair> ans = new ArrayList<>();
        int[][] dist = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(sx); q.add(sy);
        dist[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && dist[nx][ny] == -1) {
                    boolean ok = false;
                    boolean eat = false;
                    // 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
                    if (sea[nx][ny] == 0) {
                        ok = true;
                    } else if (sea[nx][ny] < size) { // 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
                        ok = eat = true;
                    } else if (sea[nx][ny] == size) { // 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
                        ok = true;
                    }
                    if (ok) {
                        q.add(nx); q.add(ny);
                        dist[nx][ny] = dist[x][y] + 1;
                        if (eat) {
                            ans.add(new Pair(dist[nx][ny], nx, ny));
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            return null;
        }
        Pair best = ans.get(0);

        // 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
        // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
        for (Pair p : ans) {
            if (best.dist > p.dist) {
                best = p;
            } else if (best.dist == p.dist && best.x > p.x) {
                best = p;
            } else if (best.dist == p.dist && best.x == p.x && best.y > p.y) {
                best = p;
            }
        }
        return best;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 바다 정보(문제에서 제시한 정보) 구현
        int[][] sea = new int[n][n];
        // 아기 상어 위치 저장
        int x = 0, y = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sea[i][j] = sc.nextInt();
                if (sea[i][j] == 9) {
                    x = i; y = j;
                    sea[i][j] = 0;
                }
            }
        }
        // 아기 상어가 엄마 상어에게 도움을 요청하지 않고
        // 물고기를 잡아먹을 수 있는 시간을 출력
        int ans = 0;
        // 아기 상어의 초기 크기
        int size = 2;
        // 물고기 먹은 횟수(아기 상어의 크기 == 물고기 먹은 횟수 -> +1)
        int exp = 0;

        while (true) {
            Pair p = bfs(sea, x, y, size);
            if (p == null) break;
            sea[p.x][p.y] = 0;
            ans += p.dist;
            exp += 1;
            if (size == exp) {
                size += 1;
                exp = 0;
            }
            x = p.x;
            y = p.y;
        }
        System.out.println(ans);
    }
}