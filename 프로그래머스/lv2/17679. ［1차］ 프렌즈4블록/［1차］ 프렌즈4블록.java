import java.util.*;
import java.io.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}



class Solution {
    public int boom(int x, int y, char[][] gameBoard) {
        int cnt = 0;

        // count
        if (gameBoard[x][y] != '#') cnt += 1;
        if (gameBoard[x + 1][y] != '#') cnt += 1;
        if (gameBoard[x][y + 1] != '#') cnt += 1;
        if (gameBoard[x + 1][y + 1] != '#') cnt += 1;

        // boom
        gameBoard[x][y] = '#';
        gameBoard[x][y + 1] = '#';
        gameBoard[x + 1][y] = '#';
        gameBoard[x + 1][y + 1] = '#';

        return cnt;
    }
    
    public boolean isValid(int x, int y, char[][] gameBoard) {
        char ch = gameBoard[x][y];

        if (ch != '#' &&
                ch == gameBoard[x + 1][y] &&
                ch == gameBoard[x + 1][y + 1] &&
                ch == gameBoard[x][y + 1]) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    public int solution(int m, int n, String[] board) {
        int ans = 0;

        char[][] gameBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }

        Queue<Pair> q = new LinkedList<>();

        while (true) {
            boolean ok = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isValid(i, j, gameBoard)) {
                        ok = true;
                        q.add(new Pair(i, j));
                    }
                }
            }

            if (ok == false) {
                break;
            } else {
                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int x = p.x;
                    int y = p.y;

                    ans += boom(x, y, gameBoard);
                }

                // move down
                for (int i=m-2; i>=0; i--) {
                    for (int j=0; j<n; j++) {
                        int mx = i, my = j;
                        while (mx < m-1 && gameBoard[mx][my] != '#' && gameBoard[mx+1][my] == '#') {
                            char tmp = gameBoard[mx][my];
                            gameBoard[mx][my] = '#';
                            gameBoard[mx+1][my] = tmp;
                            mx+=1;
                        }
                    }
                }

            }
        }


        return ans;
    }
}