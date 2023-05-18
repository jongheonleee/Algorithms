import java.util.*;
import java.io.*;

class Pair{
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String args[]) throws IOException {
        // 영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 행은 화면에 입력된 임티 개수, 열은 클립보드에 있는 임티개수
        int[][] time = new int[n+1][n+1];

        // 초기화 세팅
        for (int i=0; i<=n; i++) {
            Arrays.fill(time[i], -1);
        }


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        time[1][0] = 0;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x, y = p.y;

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (time[x][x] == -1) {
                time[x][x] = time[x][y] + 1;
                q.add(new Pair(x, x));
            }

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (x+y <= n && time[x+y][y] == -1) {
                time[x+y][y] = time[x][y] + 1;
                q.add(new Pair(x+y, y));
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (x-1 >= 0 && time[x-1][y] == -1) {
                time[x-1][y] = time[x][y] + 1;
                q.add(new Pair(x-1, y));
            }
        }

        int result = -1;
        for (int i=0; i<=n; i++) {
            if (time[n][i] != -1) {
                if (result == -1 || time[n][i] < result) {
                    result = time[n][i];
                }
            }
        }

        System.out.println(result);

    }
}