import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}



public class Main {

    static int n, m;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] map;
    static int[][] group; // 각 그룹 번호 저장
    static int[] groupSize; // 그룹의 크기 저장, idx : 그룹 번호, val : 해당 그룹 사이즈

    static boolean[][] neighbors;
    static int groupNumber; // 그룹 번호

    static int[] getDirections(int sx, int sy) {
        int num = map[sx][sy];
        int cnt = 4;
        boolean[] ban = new boolean[cnt];

        // 2 x
        if (num >= 8) {
            num -= 8;
            ban[2] = true;
        }

        // 0 x
        if (num >= 4) {
            num -= 4;
            ban[0] = true;
        }

        // 3 x
        if (num >= 2) {
            num -= 2;
            ban[3] = true;
        }

        // 1 x
        if (num >= 1) {
            num -= 1;
            ban[1] = true;
        }

        List<Integer> a = new ArrayList<>();
        for (int i=0; i<4; i++) {
            if (ban[i] != true) {
                a.add(i);
            }
        }
        return a.stream().
                mapToInt(i -> i).
                toArray();

    }

    static void bfs(int sx, int sy) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy));
        groupNumber += 1;
        group[sx][sy] = groupNumber;
        int size = 1;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int[] dir = getDirections(x, y);

            for (int i=0; i<dir.length; i++) {
                int k = dir[i];
                int nx = x+dx[k];
                int ny = y+dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (group[nx][ny] != 0) continue;
                    q.add(new Pair(nx, ny));
                    group[nx][ny] = groupNumber;
                    size += 1;
                }
            }
        }
        groupSize[groupNumber] = size;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        group = new int[n][m];
        groupSize = new int[n*m+1];
        neighbors = new boolean[n*m+1][n*m+1];
        groupNumber = 0;

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");

            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (group[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int g1 = group[i][j];

                for (int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        int g2 = group[nx][ny];
                        if (g1 != g2) {
                            neighbors[g1][g2] = true;
                        }
                    }
                }
            }
        }


        int ans1 = groupNumber;
        int ans2 = 0;
        for (int i=0; i<groupSize.length; i++) {
            if (ans2 < groupSize[i]) ans2 = groupSize[i];
        }
        int ans3 = 0;
        for (int i=0; i< neighbors.length; i++) {
            for (int j=i+1; j < neighbors[0].length; j++) {
                if (neighbors[i][j]) {
                    int sum = groupSize[i] + groupSize[j];
                    if (ans3 < sum) ans3 = sum;
                }
            }
        }


        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);


    }
}