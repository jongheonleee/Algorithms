import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Trie {

    class Node {
        boolean valid;
        int[] children;

        Node() {
            this.valid = false;
            this.children = new int[2];
            for (int i=0; i<2; i++) {
                this.children[i] = -1;
            }
        }
    }
    int root;
    ArrayList<Node> trie;

    Trie() {
        trie = new ArrayList<>();
        root = init();
    }

    int init() {
        Node x = new Node();
        trie.add(x);

        return trie.size()-1;
    }

    void add(int curr, int number, int bit) {
        if (bit == -1) {
            trie.get(curr).valid = true;
            return;
        }

        int n = (number>>bit)&1;
        if (trie.get(curr).children[n] == -1) {
            int next = init();
            trie.get(curr).children[n] = next;
        }

        int child = trie.get(curr).children[n];
        add(child, number, bit-1);
    }

    void add(int number) {
        add(root, number, 31);
    }

    int query(int number) {
        return query(root, number,31);
    }

    int query(int curr, int number, int bit) {
        int n = (number>>bit)&1;
        n = 1-n;

        if (trie.get(curr).children[n] == -1) {
            n = 1-n;
        }

        if (trie.get(curr).children[n] == -1) {
            return 0;
        }

        int next = 0;
        int child = trie.get(curr).children[n];
        if (n == 1) next = (1 << bit);

        return next | query(child, number, bit-1);
    }

}


public class Main {




    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int prefix = 0;
            int ans = 0;
            
            Trie trie = new Trie();
            trie.add(prefix);

            for (int i=0; i<n; i++) {
                int number = Integer.parseInt(line[i]);
                prefix ^= number;
                trie.add(prefix);

                int tmp = (trie.query(prefix) ^ prefix);
                if (ans < tmp) ans = tmp;
            }

            System.out.println(ans);
        }
    }
}