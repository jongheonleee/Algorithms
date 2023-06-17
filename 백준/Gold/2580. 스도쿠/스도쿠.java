import java.util.*;
import java.io.*;

public class Main {

    static final int N = 9;
    
    static final int END = N*N;
    static boolean[][] usedNumbersInRow = new boolean[N][N+1];
    static boolean[][] usedNumbersInCol = new boolean[N][N+1];
    static boolean[][] usedNumbersInSquare = new boolean[N][N+1];

    static int[][] board = new int[N][N];


    static int convert(int row, int col) {
        return 3*(row/3) + (col/3);
    }

    static boolean isValidNumber(int row, int col, int number) {
        if (usedNumbersInRow[row][number] || usedNumbersInCol[col][number] || usedNumbersInSquare[convert(row, col)][number]) {
            return false;
        }
        
        return true;
    }
    
    static void putNumber(int row, int col, int number) {
        board[row][col] = number;

        usedNumbersInRow[row][number] = true;
        usedNumbersInCol[col][number] = true;
        usedNumbersInSquare[convert(row, col)][number] = true;
    }

    static void init(int row, int col, int number) {
        board[row][col] = 0;
        
        usedNumbersInRow[row][number] = false;
        usedNumbersInCol[col][number] = false;
        usedNumbersInSquare[convert(row, col)][number] = false;
    }

    static StringBuilder getCompletedBoard() {
        StringBuilder sb = new StringBuilder();

        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) {
                sb.append(board[row][col]).append(" ");
            }
            sb.append("\n");
        }

        return sb;
    }

    static boolean go(int step) {
        if (step == END) {
            return true;
        }

        int row = step/N;
        int col = step%N;

        if (board[row][col] != 0) {
            if (go(step+1)) {
                return true;
            };
        }
        else {
            for (int number=1; number<=N; number++) {
                if (isValidNumber(row, col, number) == false) continue;

                putNumber(row, col, number);

                if (go(step+1)) {
                    return true;
                }
                else {
                    init(row, col, number);
                }
            }
        }

        return false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // implement given board
        for (int row=0; row<N; row++) {
            String[] input = br.readLine().split(" ");
            for (int col=0; col<N; col++) {
                board[row][col] = input[col].charAt(0) - '0';
            }
        }

        // set initial state of given board
        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) {
                if (board[row][col] != 0) {
                    int number = board[row][col];
                    usedNumbersInRow[row][number] = true;
                    usedNumbersInCol[col][number] = true;
                    usedNumbersInSquare[convert(row, col)][number] = true;
                }
            }
        }

        boolean ok = go(0);
        
        if (ok) {
            StringBuilder completedBoard = getCompletedBoard();
            System.out.println(completedBoard);
        }
        else {
            System.out.println(-1);
        }

    }
}