import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int m = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            // 계산을 편리하게 하기 위해 -1을 해줌
            int x = Integer.parseInt(line[2])-1;
            int y = Integer.parseInt(line[3])-1;

            // 체킹
            boolean ok = false;
            // x를 고정 시키고 y를 찾아감
            // 반복되는 구간의 크기는 m -> 건너뜀
            for (int k=x; k<m*n; k+=m) {
                // y를 찾은 경우
                if (k%n == y) {
                    System.out.println(k+1);
                    ok = true;
                    break;
                }
            }
            
            if (ok != true) {
                System.out.println(-1);
            }
        }

    }
}