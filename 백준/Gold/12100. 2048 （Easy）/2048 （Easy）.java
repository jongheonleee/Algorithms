import javax.swing.*;
import java.io.*;
import java.util.*;
public class Main {

    static final int limit = 5;
    static int[] gen(int k) {
        int[] dir = new int[limit];

        for (int i=0; i<limit; i++) {
            dir[i] = (k&3);
            k >>= 2;
        }

        return dir;
    }

    static int simulate(int[][] board, int[] dir) {
        int n = board.length;

        boolean[][] merged = new boolean[n][n];
        int[][] copyBoard = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        boolean ok = false;

        for (int d : dir) {
            ok = false;

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    merged[i][j] = false;
                }
            }

            while (true) {
                ok = false;
                // 아래
                if (d == 0) {
                    for (int i=n-2; i>=0; i--) {
                        for (int j=0; j<n; j++) {
                            if (copyBoard[i][j] == 0) continue;

                            if (copyBoard[i+1][j] == 0) {
                                copyBoard[i+1][j] = copyBoard[i][j];
                                copyBoard[i][j] = 0;
                                merged[i+1][j] = merged[i][j];
                                ok = true;
                            } else if (copyBoard[i+1][j] == copyBoard[i][j]) {
                                if (merged[i+1][j] == false && merged[i][j] == false) {
                                    copyBoard[i+1][j] *= 2;
                                    copyBoard[i][j] = 0;
                                    merged[i+1][j] = true;
                                    ok = true;
                                }
                            }
                        }
                    }
                }
                // 위
                else if (d == 1) {
                    for (int i=1; i<n; i++) {
                        for (int j=0; j<n; j++) {
                            if (copyBoard[i][j] == 0) continue;

                            if (copyBoard[i-1][j] == 0) {
                                copyBoard[i-1][j] = copyBoard[i][j];
                                copyBoard[i][j] = 0;
                                merged[i-1][j] = merged[i][j];
                                ok = true;
                            } else if (copyBoard[i-1][j] == copyBoard[i][j]) {
                                if (merged[i-1][j] == false && merged[i][j] == false) {
                                    copyBoard[i-1][j] *= 2;
                                    copyBoard[i][j] = 0;
                                    merged[i-1][j] = true;
                                    ok = true;
                                }

                            }
                        }
                    }
                }
                // 왼쩍
                else if (d == 2) {
                    for (int j=1; j<n; j++) {
                        for (int i=0; i<n; i++) {
                            if (copyBoard[i][j] == 0) continue;

                            if (copyBoard[i][j-1] == 0) {
                                copyBoard[i][j-1] = copyBoard[i][j];
                                copyBoard[i][j] = 0;
                                merged[i][j-1] = merged[i][j];
                                ok = true;
                            } else if (copyBoard[i][j-1] == copyBoard[i][j]) {
                                if (merged[i][j-1] == false && merged[i][j] == false) {
                                    copyBoard[i][j-1] *= 2;
                                    copyBoard[i][j] = 0;
                                    merged[i][j-1] = true;
                                    ok = true;
                                }

                            }
                        }
                    }
                }
                // 오른족
                else if (d == 3) {
                    for (int j=n-2; j>=0; j--) {
                        for (int i=0; i<n; i++) {
                            if (copyBoard[i][j] == 0) continue;

                            if (copyBoard[i][j+1] == 0) {
                                copyBoard[i][j+1] = copyBoard[i][j];
                                copyBoard[i][j] = 0;
                                merged[i][j+1] = merged[i][j];
                                ok = true;
                            } else if (copyBoard[i][j+1] == copyBoard[i][j]) {
                                if (merged[i][j+1] == false && merged[i][j] == false) {
                                    copyBoard[i][j+1] *= 2;
                                    copyBoard[i][j] = 0;
                                    merged[i][j+1] = true;
                                    ok = true;
                                }

                            }
                        }
                    }
                }

                if (ok == false) break;
            }
        }

        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (copyBoard[i][j] > max) {
                    max = copyBoard[i][j];
                }
            }
        }

        return max;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        // 보드판 구현
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;
        // 모든 경우의 수 구하고 시뮬레이션 돌림
        for (int k=0; k<(1<<(limit*2)); k++) {
            int[] dir = gen(k);
            int res = simulate(board, dir);

            if (max < res) {
                max = res;
            }
        }

        System.out.println(max);
    }
}