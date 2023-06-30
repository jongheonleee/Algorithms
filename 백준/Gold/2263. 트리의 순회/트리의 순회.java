import java.io.*;
import java.util.*;

public class Main {
    static final int LIMIT = 100_000;
    static int[] inOrder = new int[LIMIT+1];
    static int[] postOrder = new int[LIMIT+1];

    static int[] positions = new int[LIMIT+1];

    static void solve(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        // extract root in post order
        int root = postOrder[postEnd];
        System.out.print(root + " ");

        // divide into two trees
        int rootPos = positions[root];
        int left = rootPos - inStart;

        solve(inStart, rootPos-1, postStart, postStart + left - 1);
        solve(rootPos+1, inEnd, postStart + left, postEnd-1);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] lineInOrder = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            inOrder[i] = Integer.parseInt(lineInOrder[i]);
        }

        String[] linePostOrder = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            postOrder[i] = Integer.parseInt(linePostOrder[i]);
        }

        for (int i=0; i<n; i++) {
            positions[inOrder[i]] = i;
        }
        solve(0, n-1, 0, n-1);
    }
}