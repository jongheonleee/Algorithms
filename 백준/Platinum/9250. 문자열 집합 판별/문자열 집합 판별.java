import java.io.*;
import java.util.*;

class Node {
    int valid; // 문자열 배열에서 몇 번째 인덱스에 저장된 것인지. -1인 경우 문자열 x
    int[] children;
    int pi; // fail 부분 -> 해당 문자열의 suffix 중에 가장 긴 부분을 나타내는 노드 번호
    ArrayList<Integer> indexes; // 부분 문자열이 입력된 문자열 중 하나인 경우 그 위치를 저장함
    Node() {
        valid = -1;
        children = new int[26];
        for (int i=0; i<26; i++) {
            children[i] = -1;
        }
        pi = -1;
        indexes = new ArrayList<Integer>();
    }
}


public class Main {
    static ArrayList<Node> trie = new ArrayList<>();

    // trie 와 마찬가지
    static int init() {
        Node x = new Node();
        trie.add(x);
        return (int)trie.size()-1;
    }

    // trie 와 마찬가지
    static void add(int node, String s, int index, int string_index) {
        if (index == s.length()) {
            trie.get(node).valid = string_index;
            return;
        }
        int c = s.charAt(index) - 'a';
        if (trie.get(node).children[c] == -1) {
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], s, index+1, string_index);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int root = init();
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
            add(root, a[i], 0, i);
        }

        // BFS 를 통해서 trie 부분에서 fail 형식으로 연결해주는 과정
        Queue<Integer> q = new LinkedList<>();
        trie.get(root).pi = root;
        q.add(root);


        while (!q.isEmpty()) {
            int cur = q.remove();

            for (int i=0; i<26; i++) {
                int next = trie.get(cur).children[i];
                if (next == -1) continue;

                if (cur == root) {
                    // 레벨 1인 경우
                    trie.get(next).pi = root;
                } else {
                    // 레벨 1이 아닌 경우 fail 을 찾아감 -> suffix 이면서 최대 길이
                    int x = trie.get(cur).pi;
                    while (x != root && trie.get(x).children[i] == -1) {
                        x = trie.get(x).pi;
                    }

                    if (trie.get(x).children[i] != -1) {
                        x = trie.get(x).children[i];
                    }
                    trie.get(next).pi = x;
                }


                // 부분 문자열 넣어주기
                int pi = trie.get(next).pi;
                // 파이 부분에서 만들 수 있는 부분 문자열 중 입력된 문자의 개수를 여기에도 포함함
                trie.get(next).indexes = new ArrayList<>(trie.get(pi).indexes);
                if (trie.get(next).valid != -1) {
                    trie.get(next).indexes.add(trie.get(next).valid);
                }
                q.add(next);
            }
        }


        int m = sc.nextInt();
        while (m-- > 0) {
            String s = sc.next();
            int node = root;
            boolean ok = false;
            for (int i=0; i<s.length(); i++) {
                int c = s.charAt(i) - 'a';
                // 현재 문자와 trie 에서 포인트한 노드가 표현하는 문자가 서로 다름
                // 해당 노드의 fail(pi) 부분을 찾아감
                while (node != root && trie.get(node).children[c] == -1) {
                    node = trie.get(node).pi;
                }

                if (trie.get(node).children[c] != -1) {
                    node = trie.get(node).children[c];
                }

                if (trie.get(node).indexes.size() > 0) {
                    ok = true;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}