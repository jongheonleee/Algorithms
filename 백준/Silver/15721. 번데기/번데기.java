import java.util.*;
import java.io.*;


public class Main {

    private static final int BBUN = 0; // 뻔
    private static final int DEGI = 1; // 데기


    private static int find(int a, int target, int t) {
        int count = 2, bbun = 0, degi = 0;
        while (true) {
            for (int i=0; i<4; i++) {
                if (i%2 == 0) bbun++;
                else degi++;

                if (target == BBUN && bbun == t) {
                    return (bbun+degi-1)%a;
                }

                if (target == DEGI && degi == t) {
                    return (bbun+degi-1)%a;
                }
            }

            for (int i=0; i<count; i++) {
                bbun++;
                if (target == BBUN && bbun == t) {
                    return (bbun+degi-1)%a;
                }
            }

            for (int i=0; i<count; i++) {
                degi++;
                if (target == DEGI && degi == t) {
                    return (bbun+degi-1)%a;
                }
            }
            count++;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int ans = find(a, target, t);
        System.out.println(ans);
    }
}
