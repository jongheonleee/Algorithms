import java.util.*;
import java.io.*;
public class Main {

    static int n;
    static boolean[] check = new boolean[10];
    static ArrayList<String> result = new ArrayList<>();
    static char[] a;
    static void go(int idx, String num) {
        // 종료 & 정답을 찾은 경우
        if (idx == n+1) {
            if (ok(num)) {
                result.add(num);
            }
            return;
        }

        // 재귀를 호출하는 경우
        for (int i=0; i<=9; i++) {
            if (check[i]) continue;
            check[i] = true;
            go(idx+1, num + Integer.toString(i));
            check[i] = false;
        }
    }

    static boolean ok(String num) {
        for (int i=0; i<n; i++) {
            if (a[i] == '>') {
                if (num.charAt(i) < num.charAt(i+1)) return false;
            } else {
                if (num.charAt(i) > num.charAt(i+1)) return false;
            }
        }
        return true;
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