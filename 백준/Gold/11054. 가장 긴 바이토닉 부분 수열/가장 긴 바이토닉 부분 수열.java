import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static Integer[] dRight;
    static Integer[] dLeft;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dRight = new Integer[n];
        dLeft = new Integer[n];
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for (int i=0; i<n; i++){
            if (max < dRight[i] + dLeft[i]) {
                max = dRight[i] + dLeft[i];
            }
        }

        System.out.println(max-1);

    }

    static void LIS() {
        // 만약 탐색하지 않던 위치의 경우
        for (int i=0; i<n; i++) {
            dRight[i] = 1;

            // 0~i 이전 원소들 탐색
            for (int j=0; j<i; j++) {
                // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if (a[j] < a[i] && dRight[i] < dRight[j] + 1) {
                    // j번째 원소의 +1 값이 i번재 dp가 됨
                    dRight[i] = dRight[j] + 1;
                }
            }
        }

    }

    static void LDS() {
        // 뒤에서부터 시작
        for (int i=n-1; i>=0; i--) {
            dLeft[i] = 1;

            // 맨 뒤에서 i 이전 원소들을 탐색
            for (int j=n-1; j>i; j--) {
                // i번째 원소가 j번째 원소보다 크면서 i번째 dp가 j번재 dp+1 값보다 작은 경우
                if (a[j] < a[i] && dLeft[i] < dLeft[j]+1) {
                    // j번째 원소의 +1이 i번째 dp 값이 됨
                    dLeft[i] = dLeft[j] + 1;
                }
            }
        }

    }
}