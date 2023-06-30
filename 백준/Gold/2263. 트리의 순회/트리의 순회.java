import java.util.*;
public class Main {
    static int[] inorder = new int[100000];
    static int[] postorder = new int[100000];
    static int[] position = new int[100001];
    static void solve(int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) return;
        int root = postorder[post_end];
        System.out.print(root + " ");
        int p = position[root];

        int left = p-in_start;
        solve(in_start, p-1, post_start, post_start + left - 1);
        solve(p+1, in_end, post_start+left, post_end-1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            inorder[i] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            postorder[i] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            position[inorder[i]] = i;
        }
        solve(0, n-1, 0, n-1);
    }
}