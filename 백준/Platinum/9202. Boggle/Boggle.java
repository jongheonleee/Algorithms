import java.util.*;
public class Main {
    static int[] dx = {0,0,1,-1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int[] scores = {0,0,0,1,1,2,3,5,11};
    static boolean[][] check = new boolean[4][4];

    static void generate(int x, int y, String word, String[] dice, ArrayList<String> words) {
        words.add(word);
        if (word.length() == 8) return;

        for (int k=0; k<8; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4) {
                if (check[nx][ny] == false) {
                    check[nx][ny] = true;
                    generate(nx, ny, word + dice[nx].charAt(ny), dice, words);
                    check[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] dictionary = new String[n];

        for (int i=0; i<n; i++) {
            dictionary[i] = sc.next();
        }

        int tc = sc.nextInt();
        while (tc-- > 0) {
            String[] dice = new String[4];
            for (int i=0; i<4; i++) {
                dice[i] = sc.next();
            }

            ArrayList<String> words = new ArrayList<>();
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++) {
                    check[i][j] = true;
                    generate(i, j, Character.toString(dice[i].charAt(j)), dice, words);
                    check[i][j] = false;
                }
            }

            HashSet<String> wordSet = new HashSet<>(words);
            int score = 0;
            String longestWord = "";
            int count = 0;

            for (String word : dictionary) {
                if (wordSet.contains(word)) {
                    score += scores[word.length()];
                    count += 1;

                    if (longestWord.length() < word.length()) {
                        longestWord = word;
                    } else if (longestWord.length() == word.length() && longestWord.compareTo(word) > 0) {
                        longestWord = word;
                    }
                }
            }

            System.out.println(score + " " + longestWord + " " + count);
        }
    }
}