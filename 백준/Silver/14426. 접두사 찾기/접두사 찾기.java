import java.io.*;
import java.util.*;


class Trie {

    class Node {
        int[] children;
        boolean isWord;

        Node() {
            children = new int[26];
            Arrays.fill(children, -1);
            isWord = false;
        }
    }

    ArrayList<Node> trie;
    int root;

    int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }

    Trie() {
        trie = new ArrayList<>();
        root = init();
    }

    void add(String s) {
        add(root, s, 0);
    }

    void add(int node, String s, int idx) {
        if (idx == s.length()) {
            trie.get(node).isWord = true;
            return;
        }

        int ch = s.charAt(idx) - 'a';
        if (trie.get(node).children[ch] == -1) {
            int next = init();
            trie.get(node).children[ch] = next;
        }

        int child = trie.get(node).children[ch];
        add(child, s, idx+1);
    }

    boolean search(String s) {
        return search(root, s, 0);
    }

    boolean search(int node, String s, int idx) {
        if (node == -1) {
            return false;
        }

        if (idx == s.length()) {
            return true;
        }

        int ch = s.charAt(idx) - 'a';
        int next = trie.get(node).children[ch];
        return search(next, s, idx+1);
    }
}


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            trie.add(s);
        }

        int ans = 0;
        for (int i=0; i<m; i++) {
            String s = br.readLine();
            boolean ok = trie.search(s);
            if (ok) ans += 1;
        }

        System.out.println(ans);
    }
}