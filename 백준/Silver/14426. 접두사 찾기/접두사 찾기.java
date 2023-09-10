import java.io.*;
import java.util.*;

class Node {
    char val;
    HashMap<Character, Node> store;

    Node(char val) {
        this.val = val;
        this.store = new HashMap<>();
    }
}

class Trie {

    Node root;

    Trie() {
        root = new Node('#');
    }

    public void push(String str) {
        Node curr = this.root;

        for (char ch : str.toCharArray()) {
            if (!curr.store.containsKey(ch)) {
                curr.store.put(ch, new Node(ch));
            }
            curr = curr.store.get(ch);
        }
    }

    public boolean check(String pattern) {
        boolean ok = true;
        Node curr = this.root;

        for (char p : pattern.toCharArray()) {
            if (curr.store.containsKey(p)) {
                curr = curr.store.get(p);
            } else {
                ok = false;
                break;
            }
        }

        return ok;
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
            String str = br.readLine();
            trie.push(str);
        }

        int ans = 0;
        for (int i=0; i<m; i++) {
            String pt = br.readLine();
            boolean ok = trie.check(pt);
            if (ok) {
                ans += 1;
            }
        }


        System.out.println(ans);

    }
}