import java.util.*;
import java.io.*;

/**
 * 0. n개 전공책 중에서 특정 조합에 따라 알파벳 추출
 * 1. 선택한 전공책에서 알파벳 추출
 * 2. 재귀로 반복
 * 3. 최소 비용 기록
 */
class Book {
    String title;
    int price;

    Book(String title, int price) {
        this.title = title;
        this.price = price;
    }
}

public class Main {
    private static int n;
    private static int ans;

    private static HashMap word;

    private static Set generated;
    private static Book[] books;

    private static boolean[] selected;

    private static void go(int i) {
        if (check()) {
            calculate();
            return;
        }

        if (i >= n) return;

        String title = books[i].title;
        int[] count = new int[title.length()];
        
        // selected
        selected[i] = true;
        for (int j=0; j<title.length(); j++) {
            if (word.containsKey(title.charAt(j)) && (int)word.get(title.charAt(j)) > 0) {
                word.put(title.charAt(j), (int)word.get(title.charAt(j))-1);
                count[j] = 1;
            }
        }
        go(i+1);

        // skip
        selected[i] = false;
        for (int j=0; j<title.length(); j++) {
            if (word.containsKey(title.charAt(j)) && count[j] == 1) {
                word.put(title.charAt(j), (int)word.get(title.charAt(j))+1);
            }
        }
        go(i+1);
    }

    private static boolean check() {
        int count = 0;

        Iterator it = word.values().iterator();
        while (it.hasNext()) {
            Object val = it.next();
            count += (int)val;
        }

        return count == 0;
    }

    private static void calculate() {
        int price = 0;

        for (int j=0; j<n; j++) {
            if (selected[j]) {
                price += books[j].price;
            }
        }

        if (ans == -1 || ans != -1 && ans >= price) ans = price;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        word = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (word.containsKey(ch)) {
                word.put(ch, (int)word.get(ch)+1);
            } else {
                word.put(ch, 1);
            }
        }
        n = Integer.parseInt(br.readLine());
        ans = -1;

        generated = new HashSet();
        books = new Book[n];
        selected = new boolean[n];


        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            String title = line[1];
            int price = Integer.parseInt(line[0]);
            books[i] = new Book(title, price);
        }

        go(0);
        System.out.println(ans);
    }
}
