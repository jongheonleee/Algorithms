import java.io.*;
import java.util.*;


class Node {
    int val;
    Node left, right;

    Node() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }
}


public class Main {

    // L - R - N
    static void remove(Node root) {
        if (root.left != null) {
            remove(root.left);
        }

        if (root.right != null) {
            remove(root.right);
        }

        root = null;
    }

    // N - L - R
    static String preOrder(Node root) {
        String path = "";
        path += "N";

        if (root.left != null) {
            path += "L";
            path += preOrder(root.left);
            path += "l";
        }

        if (root.right != null) {
            path += "R";
            path += preOrder(root.right);
            path += "r";
        }

        path += "n";
        return path;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            int[] a = new int[m];
            String[] line = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                a[j] = Integer.parseInt(line[j]);
            }

            Node root = new Node();
            root.val = a[0];

            for (int j=1; j<m; j++) {
                Node curr = root;
                while (true) {
                    if (curr.val > a[j]) {
                        if (curr.left != null) {
                            curr = curr.left;
                        } else {
                            curr.left = new Node();
                            curr.left.val = a[j];
                            break;
                        }
                    } else if (curr.val < a[j]) {
                        if (curr.right != null) {
                            curr = curr.right;
                        } else {
                            curr.right = new Node();
                            curr.right.val = a[j];
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            set.add(preOrder(root));
            remove(root);
        }

        System.out.println(set.size());
    }
}