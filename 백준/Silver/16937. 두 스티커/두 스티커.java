import java.io.*;
import java.util.*;

class Sticker {
    int height, width;

    Sticker(int height, int width) {
        this.height = height;
        this.width = width;
    }

    void rotation() {
        int tmp = this.height;
        this.height = this.width;
        this.width = tmp;
    }
}

public class Main {

    static int R, C;
    static int ans = 0;
    static void check(Sticker s1, Sticker s2) {
        int maxHeight = s1.height + s2.height;
        int maxWidth = s1.width + s2.width;


        if (maxHeight <= R && Math.max(s1.width, s2.width) <= C|| maxWidth <= C && Math.max(s1.height, s2.height) <= R) {
            int size = (s1.height * s1.width) + (s2.height * s2.width);
            if (ans < size)
                ans = size;

        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        Sticker[] stickers = new Sticker[n];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            stickers[i] = new Sticker(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                Sticker s1 = stickers[i], s2 = stickers[j];
                // 노회전
                check(s1, s2);
                // s1만 회전
                s1.rotation();
                check(s1, s2);
                // s2만 회전
                s1.rotation();
                s2.rotation();
                check(s1, s2);
                // 둘 다 회전
                s1.rotation();
                check(s1, s2);

            }
        }

        System.out.println(ans);
    }
}