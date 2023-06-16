import java.util.*;
import java.io.*;

/**
 * 네 자리 소수 두 개를 입력받아서 바꾸는데 몇 단계나 필요한지 계산하게 말야.
 *
 *  입력은 항상 네 자리 소수
 *  1000 미만의 비밀번호는 허용되지 않는다
 *  두 소수 사이의 변환에 필요한 최소 회수를 출력한다. 불가능한 경우 Impossible을 출력한다.
 */
public class Main {

    static final int LIMIT = 10_000;
    static boolean[] check = new boolean[LIMIT+1];
    static int[] dist = new int[LIMIT+1];
    static boolean[] prime = new boolean[LIMIT+1];

    static void eratos() {
        for (int i=2; i<=LIMIT; i++) {
            if (prime[i] == false) {
                for (int j=i*i; j<=LIMIT; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int i=0; i<=LIMIT; i++) {
            prime[i] = !prime[i];
        }
    }

    static void init() {
        for (int i=0; i<=LIMIT; i++) {
            check[i] = false;
            dist[i] = 0;
        }
    }

    static int changeable(int currentNumbers, int pos, int number) {
        if (pos == 0 && number == 0) {
            return -1;
        }

        String currentNumbersToStr = Integer.toString(currentNumbers);
        StringBuilder sb = new StringBuilder(currentNumbersToStr);
        sb.setCharAt(pos, (char)(number + '0'));

        return Integer.parseInt(sb.toString());

    }

    static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        check[start] = true;
        dist[start] = 0;

        while (!(queue.isEmpty())) {
            int currentNumbers = queue.remove();

            for (int pos=0; pos<4; pos++) {
                for (int number=0; number<=9; number++) {
                    int nextNumbers = changeable(currentNumbers, pos, number);
                    if (nextNumbers != -1) {
                        if (prime[nextNumbers] && check[nextNumbers] == false) {
                            queue.add(nextNumbers);
                            check[nextNumbers] = true;
                            dist[nextNumbers] = dist[currentNumbers] + 1;
                        }
                    }
                }
            }
        }

        return dist[target];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        eratos();

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);

            init();
            int result = bfs(start, target);
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}