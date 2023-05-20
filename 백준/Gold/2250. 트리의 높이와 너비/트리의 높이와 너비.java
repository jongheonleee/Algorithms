import java.util.*;
import java.io.*;

class Node {
    int left;
    int right;

    public int order, depth;

    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {

    static final int LIMIT = 10000;

    static Node[] a = new Node[LIMIT+1];

    static int[] cnt = new int[LIMIT+1];

    static int order = 0;

    static int[] left = new int[LIMIT+1];

    static int[] right = new int[LIMIT+1];

    // L -> N -> R
    static void inorder(int x, int depth) {
        if (x == -1) {
            return;
        }

        inorder(a[x].left, depth+1);
        a[x].order = ++order;
        a[x].depth = depth;
        inorder(a[x].right, depth+1);
    }



    public static void main(String args[]) throws IOException {
        // 트리 구현하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int z = Integer.parseInt(line[2]);

            a[x] = new Node(y, z);

            if (y != -1) {
                cnt[y] += 1;
            }

            if (z != -1) {
                cnt[z] += 1;
            }
        }
        // 루트 찾기(조상이 없는 것이 루트)
        int loot = 0;
        for (int i=1; i<=n; i++) {
            if (cnt[i] == 0) {
                loot = i;
            }
        }

        // 각 정점에 대해서 깊이와 방문순서 기록해주기(inorder)
        inorder(loot, 1);

        // left, right 채우기 -> 깊이 depth를 기준으로 가장 최근에 방문한 순서 left, 나중에 방문한 순서 right
        for (int i=1; i<=n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;

            if (left[depth] == 0) {
                left[depth] = order;
            }
            else {
                left[depth] = Math.min(left[depth], order);
            }
            right[depth] = Math.max(right[depth], order);
        }


        // 최대 깊이 찾기
        int maxDepth = 0;
        for (int i=1; i<=n; i++) {
            if (a[i].depth > maxDepth) {
                maxDepth = a[i].depth;
            }
        }

        int ans = 0;
        int ansDepth = 0;
        for (int i=1; i<=maxDepth; i++) {
            if (ans < right[i] - left[i] + 1) {
                ans = right[i] - left[i] + 1;
                ansDepth = i;
            }
        }
        System.out.println(ansDepth + " " + ans);

    }
}