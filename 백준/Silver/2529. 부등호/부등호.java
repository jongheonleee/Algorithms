import java.util.*;
import java.io.*;
public class Main {

    static int n;
    static char[] a;
    static boolean[] check = new boolean[10];
    static ArrayList<String> result = new ArrayList<>();

    static boolean good(char x, char y, char op) {
        if (op == '>') {
            if (x < y) return false;
        }
        else {
            if (x > y) return false;
        }

        return true;
    }

    static void go(int idx, String num) {
        // 정답을 찾은 경우
        if (idx == n+1) {
            result.add(num);
            return;
        }

        for (int i=0; i<=9; i++) {
            if (check[i]) continue;

            if (idx == 0 || good(num.charAt(idx-1), (char)(i+'0'), a[idx-1])) {
                check[i] = true;
                go(idx+1, num + Integer.toString(i));
                check[i] = false;
            }
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new char[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = line[i].charAt(0);
        }

        go(0, "");
        Collections.sort(result);
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));

    }
}