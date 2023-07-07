import java.util.*;
import java.io.*;

class Pair {
    long row, col;

    Pair(long row, long col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static final int IMPOSSIBLE = -1;

    private static Pair strToPair(String s, int i, long r, long c, long len) {
        if (len == 1) {
            return new Pair(r, c);
        }

        long m = len/2;

        if (s.charAt(i) == '1') {
            return strToPair(s, i+1, r, c+m, m);
        } else if (s.charAt(i) == '2') {
            return strToPair(s, i+1, r, c, m);
        } else if (s.charAt(i) == '3') {
            return strToPair(s, i+1, r+m, c, m);
        } else if (s.charAt(i) == '4') {
            return strToPair(s, i+1, r+m, c+m, m);
        }

        return new Pair(0, 0);
    }

    private static String pairToStr(long r, long c, long len, long x, long y) {
        if (len == 1) {
            return "";
        }
        else {
            long m = len/2;

            if (x < r+m && y < c+m) {
                return '2' + pairToStr(r, c, m, x, y);
            } else if (x < r+m && y >= c+m) {
                return '1' + pairToStr(r, c+m, m, x, y);
            } else if (x >= r+m && y < c+m) {
                return '3' + pairToStr(r+m, c, m, x, y);
            } else {
                return '4' + pairToStr(r+m, c+m, m, x, y);
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int d = Integer.parseInt(line1[0]);
        Long len = (1L << d);
        String src = line1[1];

        Pair p = strToPair(src, 0, 0, 0, len);

        String[] line2 = br.readLine().split(" ");
        long dc = Long.parseLong(line2[0]);
        long dr = Long.parseLong(line2[1]);
        dr = -dr;

        p.row += dr; p.col += dc;

        if (0 <= p.row && p.row < len && 0 <= p.col && p.col < len) {
            System.out.println(pairToStr(0, 0, len, p.row, p.col));
        } else {
            System.out.println(IMPOSSIBLE);
        }
    }
}