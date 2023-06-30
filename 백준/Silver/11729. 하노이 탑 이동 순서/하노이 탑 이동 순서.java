import java.io.*;
import java.util.*;

public class Main {

    private static void solve(int n, int x, int y, StringBuilder sb) {
        if (n == 0) return;

        solve(n-1, x, 6-x-y, sb);
        sb.append(x).append(" ").append(y).append("\n");
        solve(n-1, 6-x-y, y, sb);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println((1<<n)-1);
        StringBuilder sb = new StringBuilder();
        solve(n, 1, 3, sb);
        System.out.println(sb);

    }
}