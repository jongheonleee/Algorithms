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

    static int row, col, limit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static int[][] distGramX;
    static int[][] distGramO;



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        distGramX = new int[row][col]; // 그람 x
        distGramO = new int[row][col]; // 그람 o

        // 초기화 및 구현
        int gramX = -1, gramY = -1;
        for (int i=0; i<row; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<col; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                distGramX[i][j] = -1;
                distGramO[i][j] = -1;
            }
        }


        // 경로 1 - 그람 없이 공주한테 도달하는 최단 거리
        Queue<Pair> q = new LinkedList<>();
        distGramX[0][0] = 0;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < row && 0 <= ny && ny < col) {
                    if (map[nx][ny] != 1 && distGramX[nx][ny] == -1) {
                        if (map[nx][ny] == 2) {
                            gramX = nx;
                            gramY = ny;
                        }
                        distGramX[nx][ny] = distGramX[x][y]+1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        int ansGramX = distGramX[row-1][col-1];
        int ans = ansGramX != -1 ? ansGramX : -1;

        // 그람에 도달 할 수 없음
//        if (gramX == -1 && gramY == -1) {
//            System.out.println(ans != -1 && ans <= limit ? ans : "Fail");
//            System.exit(0);
//        }

        if (gramX == -1 && gramY == -1) {
            if (ans != -1 && limit >= ans) {
                System.out.println(ans);
            } else {
                System.out.println("Fail");
            }
            System.exit(0);
        }

        // 경로 2 - 그람을 가지고 공주한테 도달하는 최단거리
        distGramO[gramX][gramY] = distGramX[gramX][gramY];
        q.add(new Pair(gramX, gramY));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            for (int k=0; k<4; k++) {
                int nx = x+dx[k], ny = y+dy[k];

                if (0 <= nx && nx < row && 0 <= ny && ny < col) {
                    // 그람이 있으면 벽도 통과할 수 있음
                    if (distGramO[nx][ny] == -1) {
                        distGramO[nx][ny] = distGramO[x][y]+1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

//        int ansGramO = distGramO[row-1][col-1];
//        ans = ansGramO != -1 && ans >= ansGramO ? ansGramO : ans;
//        System.out.println(ans != -1 && ans <= limit ? ans : "Fail");

        int tmp1 = distGramX[row-1][col-1];
        int tmp2 = distGramO[row-1][col-1];
        int res = -1;

        if (tmp1 != -1 && tmp2 != -1) {
            if (tmp1 >= tmp2) {
                res = tmp2;
            } else {
                res = tmp1;
            }
        } else if (tmp1 != -1) {
            res = tmp1;
        } else if (tmp2 != -1) {
            res = tmp2;
        }

        if (res != -1 && res <= limit) {
            System.out.println(res);
        } else {
            System.out.println("Fail");
        }
    }
}