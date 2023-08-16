import java.util.*;
import java.io.*;

class Egg {
    int d, w;

    Egg(int d, int w) {
        this.d = d;
        this.w = w;
    }
}

public class Main {

    static int n;
    static Egg[] eggs;
    static int go(int i) {
        if (i == n) {
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (eggs[j].d <= 0) cnt++;
            }

            return cnt;
        }

        if (eggs[i].d <= 0) return go(i+1);

        boolean ok = false;
        int ans = 0;

        for (int j=0; j<n; j++) {
            if (i == j) continue;

            if (eggs[j].d > 0) {
                ok = true;
                eggs[j].d -= eggs[i].w;
                eggs[i].d -= eggs[j].w;
                int tmp = go(i+1);
                if (ans < tmp) ans = tmp;
                eggs[j].d += eggs[i].w;
                eggs[i].d += eggs[j].w;
            }
        }

        if (!ok) {
            return go(i+1);
        }

        return ans;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        eggs = new Egg[n];
        for (int i=0; i<n; i++) {
            String[] egg = br.readLine().split(" ");
            int d = Integer.parseInt(egg[0]);
            int w = Integer.parseInt(egg[1]);
            eggs[i] = new Egg(d, w);
        }

        int ans = go(0);
        System.out.println(ans);

    }
}