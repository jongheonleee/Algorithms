import java.io.*;
import java.util.*;


class Node  {
    int valid;
    int[] children;
    int pi;
    ArrayList<Integer> store;

    Node() {
        this.valid = -1;
        this.children = new int[26];
        for (int i=0; i<26; i++) {
            this.children[i] = -1;
        }
        this.pi = -1;
        this.store = new ArrayList<>();
    }
}


public class Main {

    static int root;
    static ArrayList<Node> trie = new ArrayList<>();

    static int init() {
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }

    static void add(int node, String str, int idx, int stringIdx) {
        if (str.length() == idx) {
            trie.get(node).valid = stringIdx;
            return;
        }

        int ch = str.charAt(idx)-'a';
        if (trie.get(node).children[ch] == -1) {
            int next = init();
            trie.get(node).children[ch] = next;
        }

        int child = trie.get(node).children[ch];
        add(child, str, idx+1, stringIdx);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        root = init();
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            add(root, str, 0, i);
        }

        Queue<Integer> q = new LinkedList<>();
        trie.get(root).pi = root;
        q.add(root);

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i=0; i<26; i++) {
                int next = trie.get(curr).children[i];

                if (next == -1) continue;

                if (curr == root) {
                    trie.get(next).pi = root;
                } else {
                    int x = trie.get(curr).pi;
                    while (x != root && trie.get(x).children[i] == -1) {
                        x = trie.get(x).pi;
                    }

                    if (trie.get(x).children[i] != -1) {
                        x = trie.get(x).children[i];
                    }
                    trie.get(next).pi = x;
                }

                int pi = trie.get(next).pi;
                trie.get(next).store = new ArrayList<>(trie.get(pi).store);

                if (trie.get(next).valid != -1) {
                    trie.get(next).store.add(trie.get(next).valid);
                }

                q.add(next);
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            String str = br.readLine();
            int curr = root;
            boolean ok = false;

            for (int j=0; j<str.length(); j++) {
                int ch = str.charAt(j)-'a';

                while (curr != root && trie.get(curr).children[ch] == -1) {
                    curr = trie.get(curr).pi;
                }

                if (trie.get(curr).children[ch] != -1) {
                    curr = trie.get(curr).children[ch];
                }

                if (trie.get(curr).store.size() > 0) {
                    ok = true;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }


    }
}