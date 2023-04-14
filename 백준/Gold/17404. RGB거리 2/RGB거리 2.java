import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
				// 각 집의 RGB 색상을 칠할 때 발생하는 비용 저장
        int[][] a = new int[n+1][3];
				// DP 메모 공간
        int[][] d = new int[n+1][3];
        for (int i=1; i<=n; i++) {
            for (int j=0; j<3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
				// ans의 최대값 설정 -> 최소값 구하기
        int ans = 1000*1000 + 1;
				// 첫 번째 집의 색을 고정함
        for (int k=0; k<=2; k++) {
            for (int j=0; j<=2; j++) {
								// 첫 번째 집의 색을 초기화 시켜줌
                if (j == k) {
                    d[1][j] = a[1][j];
                }
								// 고정 시킬 색과 같지 않은 경우 최대값으로 초기 세팅해주기 
								else {
                    d[1][j] = 1000*1000+1;
                }
            }
						// 첫 번째 집 이후의 집들의 색들을 정해주면서 해당 값들의 가격을 계산하고
						// 최대값을 저장함
            for (int i=2; i<=n; i++) {
                d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + a[i][0];
                d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + a[i][1];
                d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + a[i][2];
            }
						// d[n][k]가 결정되었을 때, 해당 값들 중에 최소값을 결과값에 저장함
            for (int j=0; j<=2; j++) {
								// 이때, 첫 번째 집과 마지막 집의 색은 같으면 안되기 때문에 해당 경우는 스킵함
                if (j == k) continue;
                ans = Math.min(ans, d[n][j]);
            }
        }
        System.out.println(ans);
    }
}