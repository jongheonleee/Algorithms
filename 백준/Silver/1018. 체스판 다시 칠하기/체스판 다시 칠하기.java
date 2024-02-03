import java.util.*;
import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    private static int n, m, ans;
    private static String[] board, result1, result2;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
            // 0-0. n, m 받기 -> cv
            // 0-1. 보드판 구현 -> cv
            // 0-2. 결과 보드 2개 만들기 -> cv
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        ans = n*m;

        board = new String[n];
        for (int i=0; i<n; i++) {
            String line2 = br.readLine();
            board[i] = line2;
        }

        result1 = new String[8];
        result2 = new String[8];
        for (int i=0; i<8; i++) {
            String tmp1 = "";
            String tmp2 = "";
            for (int j=0; j<8; j++) {
                if ((i+j)%2 == 0) {
                    tmp1 += "W";
                    tmp2 += "B";
                } else {
                    tmp1 += "B";
                    tmp2 += "W";
                }
            }
            result1[i] = tmp1;
            result2[i] = tmp2;
        }

        // 1. (n-8) * (m-8) 중에 한개 선정 -> x, y
            // 1-0. (x, y) ~ (x+7, y+7)
            // 1-1. 결과 보드 2개와 비교
            // 1-2. 그 중에 최소 개수 기록
            // 1-3. 기존에 기록한 값과 비교하고 업데이트
        for (int i=0; i<=n-8; i++) {
            for (int j=0; j<=m-8; j++) {
                int tmp = 0;
                int cnt1 = 0;
                int cnt2 = 0;
                for (int x=i; x<i+8; x++) {
                    for (int y=j; y<j+8; y++) {
                        if (board[x].charAt(y) != result1[x-i].charAt(y-j)) {
                            cnt1++;
                        }
                        if (board[x].charAt(y) != result2[x-i].charAt(y-j)) {
                            cnt2++;
                        }
                    }
                }

                tmp = cnt1 > cnt2 ? cnt2 : cnt1;
                if (ans > tmp) ans = tmp;
            }
        }


        // 2. 결과 출력
        System.out.println(ans);

   }
}

