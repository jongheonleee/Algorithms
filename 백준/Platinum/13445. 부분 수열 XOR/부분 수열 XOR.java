import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Trie {
    class Node {
        boolean valid;
        int[] cnt;
        int[] children;

        Node() {
            valid = false;
            cnt = new int[2];
            children = new int[2];
            for (int i=0; i<2; i++) {
                cnt[i] = 0;
                children[i] = -1;
            }
        }
    }

    ArrayList<Node> trie;
    int root;

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

        int c = (number>>bit)&1;
        if (trie.get(curr).children[c] == -1) {
            int next = init();
            trie.get(curr).children[c] = next;
        }

        trie.get(curr).cnt[c] += 1;
        int child = trie.get(curr).children[c];
        add(child, number, bit-1);
    }

    void add(int number) {
        add(root, number, 20);
    }

    int query(int curr, int number, int k, int bit) {
        if (bit == -1) return 0;
        int ans = 0;

        int c1 = (k>>bit)&1;
        int c2 = (number>>bit)&1;

        if (c1 == 1) {
            ans += trie.get(curr).cnt[c2];
            c2 = 1-c2;
        }

        if (trie.get(curr).children[c2] == -1) {
            return ans;
        }

        int child = trie.get(curr).children[c2];
        ans += query(child, number, k, bit-1);

        return ans;

    }

    int query(int number, int k) {
        return query(root, number, k, 20);
    }
}


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] line = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        Trie trie = new Trie();
        int prefix = 0;
        trie.add(0);
        long ans = 0;

        for (int i=0; i<n; i++) {
            int number = a[i];
            prefix ^= number;
            ans += trie.query(prefix, k);
            trie.add(prefix);
        }

        System.out.println(ans);


    }
}