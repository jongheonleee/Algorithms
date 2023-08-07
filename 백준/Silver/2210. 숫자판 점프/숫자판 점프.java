import java.util.*;
import java.io.*;



public class Main {

    static boolean[] check;
    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    static int power10(int k) {
        return (int)Math.pow(10, k);
    }

    static void dfs(int x, int y, int number, int depth) {
        if (depth == 6) {
            if (check[number] == false) {
                cnt++;
                check[number] = true;
            }
            return;
        }

        for (int k=0; k<4; k++) {
            int nx = x+dx[k], ny = y+dy[k];
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                dfs(nx, ny, number*10 + map[nx][ny], depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        check = new boolean[power10(6)];
        map = new int[5][5];

        for (int i=0; i<5; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                dfs(i, j, map[i][j], 1);
            }
        }
        System.out.println(cnt);



    }
}