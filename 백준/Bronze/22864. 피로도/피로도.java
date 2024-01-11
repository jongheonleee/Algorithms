import java.util.*;
import java.io.*;



public class Main {

    private static boolean[] score;
    private static int a;
    private static int b;
    private static int c;
    private static int m;

    private static void go(int time, int x, int y) {
        // 24시간 지난 경우
        if (time == 24) {
            if (x < m) {
                score[y] = true;
            }
            return;
        }

        // 피로도 음수면 0 세팅
        if (x <= 0) {
            x = 0;
        }

        // 번아웃
        if (x > m) {
            y = 0;
        }

        // 일을 한 경우
        go(time+1, x+a, y+b);
        // 일을 하지 않은 경우
        go(time+1, x-c, y);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        a = Integer.parseInt(arr[0]);
        b = Integer.parseInt(arr[1]);
        c = Integer.parseInt(arr[2]);
        m = Integer.parseInt(arr[3]);
        score = new boolean[b*24+1];

        go(0, 0, 0);

        int ans = 0;
        for (int i=0; i< score.length; i++) {
            if (score[i] && ans <= i) ans = i;
        }

        System.out.println(ans);


    }
}