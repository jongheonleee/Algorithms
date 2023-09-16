import java.util.*;
class Node {
    boolean valid;
    int[] children;
    Node() {
        valid = false;
        children = new int[10];
        for (int i=0; i<10; i++) {
            children[i] = -1;
        }
    }
}
public class Main {
    static ArrayList<Node> trie;
    static int init() {
        Node x = new Node();
        trie.add(x);
        return (int)trie.size()-1;
    }
    static void add(int node, String s, int index) {
        if (index == s.length()) {
            trie.get(node).valid = true;
            return;
        }
        int c = s.charAt(index) - '0';
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], s, index+1);
    }
    static boolean check(int node) {
        for (int i=0; i<10; i++) {
            if (trie.get(node).children[i] != -1) {
                if (trie.get(node).valid == true) {
                    return false;
                } else {
                    if (!check(trie.get(node).children[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            trie = new ArrayList<Node>();
            int root = init();
            for (int i=0; i<n; i++) {
                a[i] = sc.next();
                add(root, a[i], 0);
            }
            if (check(root)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}