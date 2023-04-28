import java.io.*;
import java.util.Arrays;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static String[] a;

    static void go(int i, String pw, int l) {
        // 정답을 찾은 경우
        if (pw.length() == l) {
            if (check(pw)) {
                sb.append(pw).append("\n");
            }
            return;
        }

        // 종료 조건
        if (i > a.length-1) return;

        // 재귀 호출 진행
        // a[i]를 선택한 경우
        go(i+1, pw+a[i], l);
        // a[i]를 선택하지 않은 경우
        go(i+1, pw, l);
    }

    // 최소 한 개의 모음 두 개의 자음으로 구성되어 있는지 확인
    static boolean check(String pw) {
        int mo = 0, ja = 0;

        for (char c : pw.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mo++;
            }
            else {
                ja++;
            }
        }
        return mo >= 1 && ja >= 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        int l = Integer.parseInt(line1[0]), c = Integer.parseInt(line1[1]);
        a = new String[c];
        for (int i=0; i<c; i++) a[i] = line2[i];
        Arrays.sort(a);

        go(0, "", l);
        System.out.println(sb);


    }
}