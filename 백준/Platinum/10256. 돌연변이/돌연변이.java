import java.io.*;
import java.util.*;

class Node {
    int valid;
    int[] children;
    int pi;
    ArrayList<Integer> store;

    Node() {
        this.valid = -1;
        this.children = new int[4];
        Arrays.fill(this.children, -1);
        this.pi = -1;
        this.store = new ArrayList<>();
    }
}


public class Main {

    static int root;
    static ArrayList<Node> trie;

    static int calc(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'T') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else if (ch == 'C'){
            return 3;
        } else {
            return 4;
        }
    }
    
    static int init() {
        Node x = new Node();
        trie.add(x);

        return trie.size()-1;
    }

    static void add(int curr, int idx, int mark, String str) {
        if (idx == str.length()) {
            trie.get(curr).valid = mark;
            return;
        }

        int ch = calc(str.charAt(idx));
        if (trie.get(curr).children[ch] == -1) {
            int next = init();
            trie.get(curr).children[ch] = next;
        }

        int child = trie.get(curr).children[ch];
        add(child, idx+1, mark, str);

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String dna = br.readLine();
            String marker = br.readLine();

            trie = new ArrayList<>();
            root = init();

            for (int i=0; i<m; i++) {
                for (int j=i; j<m; j++) {
                    String changed = new StringBuilder(marker.substring(i, j+1)).reverse().toString();
                    String mutation = marker.substring(0, i) + changed + marker.substring(j+1);
                    add(root, 0, 1, mutation);

                }
            }

            Queue<Integer> q = new LinkedList<>();
            trie.get(root).pi = root;
            q.add(root);

            while (!q.isEmpty()) {
                int curr = q.remove();

                for (int i=0; i<4; i++) {
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

            int cnt = 0;
            int curr = root;

            for (int i=0; i<n; i++) {
                int ch = calc(dna.charAt(i));

                while (curr != root && trie.get(curr).children[ch] == -1) {
                    curr = trie.get(curr).pi;
                }

                if (trie.get(curr).children[ch] != -1) {
                    curr = trie.get(curr).children[ch];
                }

                if (trie.get(curr).store.size() > 0) {
                    cnt += trie.get(curr).store.size();
                }
            }

            System.out.println(cnt);
        }
    }
}