import java.util.*;
import java.io.*;


public class Main {
    static final int LIMIT = 100_000;
    static int[] inOrder = new int[LIMIT+1];
    static int[] postOrder = new int[LIMIT+1];
    static int[] positions = new int[LIMIT+1];
    static StringBuilder sb = new StringBuilder();

    private static void solve(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        // N
        int root = postOrder[postEnd];
        sb.append(root).append(" ");

        int rootPos = positions[root];
        int left = rootPos - inStart;

        // L
        solve(inStart, inStart+left-1, postStart, postStart+left-1);

        // R
        solve(inStart+left+1, inEnd, postStart+left, postEnd-1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] line1 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            inOrder[i] = Integer.parseInt(line1[i]);
            positions[inOrder[i]] = i;
        }

        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            postOrder[i] = Integer.parseInt(line2[i]);
        }

        solve(0, n-1, 0, n-1);
        System.out.println(sb);
    }
}