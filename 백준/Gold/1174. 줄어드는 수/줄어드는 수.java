import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class Main {

    static long[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Long> q = new LinkedList<>();
        int cnt = 0;
        // 첫번째 담기
        for (int i=0; i<a.length; i++) {
            cnt+=1;
            q.add(a[i]);
            if (cnt == n) {
                System.out.println(a[i]);
                System.exit(0);
            }
        }


        while (!q.isEmpty()) {
            long num = q.remove();
            long last = num%10;

            for (int i=0; i<a.length; i++) {
                if (last > a[i]) {
                    cnt += 1;
                    long next = num*10+a[i];
                    q.add(next);

                    if (cnt == n) {
                        System.out.println(next);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(-1);

    }
}
