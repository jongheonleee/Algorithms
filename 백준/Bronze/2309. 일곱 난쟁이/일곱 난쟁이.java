import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] h = new int[9];
        for(int i=0; i<9; i++) h[i] = Integer.parseInt(br.readLine());

        // 전체 합
        int total = 0, diff = 0;
        for (int i=0; i<9; i++) total += h[i];

        // 차이 = 전체 - 100
        diff = total - 100;

        // 밑에 알고리즘의 예외 발생을 막기 위해 정렬해주기
        Arrays.sort(h);
        // 2명 키의 합이 diff인 경우 찾기
        for (int i=0; i<h.length; i++) {
            for (int j=i+1; j<h.length; j++) {
                if (diff == h[i] + h[j]) {
                    for (int k=0; k<h.length; k++) {
                        if ( k != i && k != j) {
                            sb.append(h[k]).append("\n");
                        }
                    }        
										// 출력하기
						        System.out.println(sb);
										System.exit(0);
									
                }
            }
        }

    }
}