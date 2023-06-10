import java.io.*;
import java.util.*;

public class Main {

    static final int LIMIT = 10000;

    static int[] dist = new int[LIMIT+1];
    static boolean[] check = new boolean[LIMIT+1];
    static int[] from = new int[LIMIT+1];

    static char[] how = new char[LIMIT+1];


    static int operatorD(int n) {
        int res = 0;

        res = (n*2)%LIMIT;
        return res;
    }

    static int operatorS(int n) {
        int res = 0;

        res = n-1;

        if (res < 0) {
            res = LIMIT-1;
        }

        return res;
    }

    static int operatorL(int n) {
        int res = 0;

        res = (n%1000) * 10 + (n/1000);
        return res;
    }

    static int operatorR(int n) {
        int res = 0;

        res = (n%10) * 1000 + (n/10);
        return res;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- != 0) {
            String[] line = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]);

            // cv 초기화
            for (int i=0; i<LIMIT; i++) {
                dist[i] = -1;
                check[i] = false;
                from[i] = -1;
                how[i] = '#';
            }

            // bfs 알고리즘 시작
            Queue<Integer> q = new LinkedList<>();
            q.add(a);
            dist[a] = 0; check[a] = true; from[a] = -1; how[a] = '#';

            while (!q.isEmpty()) {
                int now = q.remove();

                int next1= operatorD(now);
                int next2 = operatorS(now);
                int next3 = operatorL(now);
                int next4 = operatorR(now);

                // 큐에 담을 수 있는지 유효성 검사하기
                if (check[next1] == false) {
                    // 다음 값에 탐색 처리 적용
                    dist[next1] = dist[now] + 1;
                    check[next1] = true;
                    from[next1] = now;
                    how[next1] = 'D';

                    q.add(next1);
                }

                if (check[next2] == false) {
                    dist[next2] = dist[now] + 1;
                    check[next2] = true;
                    from[next2] = now;
                    how[next2] = 'S';

                    q.add(next2);
                }

                if (check[next3] == false) {
                    dist[next3] = dist[now] + 1;
                    check[next3] = true;
                    from[next3] = now;
                    how[next3] = 'L';

                    q.add(next3);
                }

                if (check[next4] == false) {
                    dist[next4] = dist[now] + 1;
                    check[next4] = true;
                    from[next4] = now;
                    how[next4] = 'R';

                    q.add(next4);
                }


                // b에 도달한 경우
                if (check[b] == true) {
                    // 역추적해서 정답 경로 sb 객체에 담아주기
                    while (true) {
                        if (b == a) {
                            break;
                        }
                        sb.append(how[b]);
                        b = from[b];
                    }
                    break;
                }
            }
            System.out.println(sb.reverse());
        }
    }
}