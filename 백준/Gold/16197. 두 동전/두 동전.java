import java.util.*;
public class Main {
    static int n, m;
    static char[][] a;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int go(int step, int x1, int y1, int x2, int y2) {
        // 불가능한 경우
				if (step == 11) return -1;
        
				boolean fall1 = false;
        boolean fall2 = false;
				// 동전이 떨어졌는지 확인하기
        if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) fall1 = true;
        if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= m) fall2 = true;
        // 둘 다 떨어진 경우는 불가능한 경우
				if (fall1 && fall2) return -1;
				// 하나만 떨어진 경우는 정답을 찾은 경우
        if (fall1 || fall2) return step;
				
        int ans = -1;
        for (int k=0; k<4; k++) {
						// 두 동전의 다음 위치
            int nx1 = x1+dx[k];
            int ny1 = y1+dy[k];
            int nx2 = x2+dx[k];
            int ny2 = y2+dy[k];
            // 벽이 있는 경우 움직이지 않음
						if (0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m && a[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }
            if (0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m && a[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }
						// 최소값 갱신하기
            int temp = go(step+1, nx1, ny1, nx2, ny2);
            if (temp == -1) continue;
            if (ans == -1 || ans > temp) {
                ans = temp;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        int x1,y1,x2,y2;
        x1=y1=x2=y2=-1;
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
            for (int j=0; j<m; j++) {
								// 동전위치 저장해주기
                if (a[i][j] == 'o') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
										// 위치 지워주기
                    a[i][j] = '.';
                }
            }
        }
        System.out.println(go(0,x1,y1,x2,y2));
    }
}