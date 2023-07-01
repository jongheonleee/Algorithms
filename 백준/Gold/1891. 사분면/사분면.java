import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    long row, col;

    Pair(long row, long col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static final int IMPOSSIBLE = -1;

    static Pair go(String a, int idx, long r, long c, long size) {
        if (size == 1) {
            return new Pair(r, c);
        }


        long m = size/2;

        if (a.charAt(idx) == '1') {
            return go(a, idx+1, r, c+m, m);
        }
        else if (a.charAt(idx) == '2') {
            return go(a, idx+1, r, c, m);
        }
        else if (a.charAt(idx) == '3') {
            return go(a, idx+1, r+m, c, m);
        }
        else {
                // a.charAt(idx) == '4'
            return go(a, idx+1, r+m, c+m, m);
        }


    }

    static String gogo(long r, long c, long size, long x, long y) {
        if (size == 1) {
            return "";
        }
        else {
            long m = size/2;

            if (x < r+m && y < c+m) {
                return "2" + gogo(r, c, m, x, y);
            }
            else if (x >= r+m && y < c+m) {
                return "3" + gogo(r+m, c, m, x, y);
            }
            else if (x < r+m && y >= c+m) {
                return "1" + gogo(r, c+m, m, x, y);
            }
            else {
                // x >= r+m && y >= c+m
                return "4" + gogo(r+m, c+m, m, x, y);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        long d = Integer.parseInt(line1[0]);
        long size = (1L << d);
        String src = line1[1];

        Pair p = go(src, 0, 0, 0, size);

        String[] line2 = br.readLine().split(" ");
        long dc = Long.parseLong(line2[0]);
        long dr = Long.parseLong(line2[1]);
        dr = -dr;

        p.row += dr;
        p.col += dc;

        if (0 <= p.row && p.row < size && 0 <= p.col && p.col < size) {
            System.out.println(gogo(0, 0, size, p.row, p.col));
        }
        else {
            System.out.println(IMPOSSIBLE);
        }


    }
}