import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

    private static int[] dx = {-1, 0, 1, 1};
    private static int[] dy = {1, 1, 1, 0};

    public static void main(String args[]) throws IOException {
        // 0. 세팅
            // 0-1. 바둑판 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[19][19];

        for (int i=0; i<19; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<19; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int winnerX = 0, winnerY = 0, winner = 0;
        // 1. 탐색
            // 1-0. 시작점 (x, y) 지정
            // 1-1. 네 방향 중 한방향으로 탐색
                // 1-1-0. (x-1, y+1), (x, y+1), (x+1, y+1), (x+1, y)
                // 1-1-1. 탐색 길이가 5이면 중단
                // 1-1-2. 추가 조건 확인
                    // 1-1-2-0. (x, y) 이전 방향에 같은 돌이 있는지
                    // 1-1-2-1. (currX, currY) 다음 방향에 같은 돌이 있는지
                // 1-1-3. 위 조건 만족시 바둑알과 해당 좌표 가록
        for (int x=0; x<19; x++) {
            for (int y=0; y<19; y++) {
                if (board[x][y] != 0) {
                    int mark = board[x][y];

                    for (int k=0; k<4; k++) {
                        int dirX = dx[k], dirY = dy[k];
                        int nx = x + dirX, ny = y + dirY;
                        int length = 1;
                        while (0 <= nx && nx < 19 && 0 <= ny && ny < 19) {
                            if (board[nx][ny] != mark) break;
                            if (length == 5) break;
                            nx += dirX;
                            ny += dirY;
                            length += 1;
                        }

                        if (length == 5) {
                            boolean ok = true;

                            int px = x-dirX, py = y-dirY;
                            int lx = x+5*dirX, ly = y+5*dirY;

                            if (0 <= px && px < 19 && 0 <= py && py < 19) {
                                if (board[px][py] == mark) ok = false;
                            }

                            if (0 <= lx && lx < 19 && 0 <= ly && ly < 19) {
                                if (board[lx][ly] == mark) ok = false;
                            }

                            if (ok) {
                                winner = mark;
                                winnerX = x+1;
                                winnerY = y+1;
                            }
                        }
                    }

                }
            }
        }

        // 2. 결과 출력
        if (winner == 0) {
            System.out.println(winner);
        } else {
            System.out.println(winner);
            System.out.println(winnerX + " " + winnerY);
        }


    }
}
