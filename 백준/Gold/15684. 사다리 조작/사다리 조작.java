import java.util.*;
// 사다리 위치 정보 정의
class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Main {
		// 사다리 연결 정보 저장
    static int[][] garo = new int[100][100];
    // 너비, 높이
		static int w, h;
		// 시뮬레이션2 : c를 넣어서 사다리 타고 내려갈 때 어떤 값이 나오는지 출력
    static int start(int c) {
        int r = 1;
        while (r <= h) {
            if (garo[r][c] == 1) {
                c += 1;
            } else if (garo[r][c] == 2) {
                c -= 1;
            }
            r += 1;
        }
        return c;
    }
		// 시뮬레이션1 : 각각의 시작점 i 을 start(i) 호출해서 사다리타고 내려갈 때 어떤값이
		//            나오는지 파악
		//            문제의 조건 i -> i가 나와야함, 즉 i->i면 true 아니면 false
    static boolean go() {
        for (int i=1; i<=w; i++) {
            int res = start(i);
            if (res != i) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        w = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
						// 왼쪽 끝점
            garo[x][y] = 1;
						// 오른쪽 끝점
            garo[x][y+1] = 2;
        }
				// 가로선을 추가할 수 있는 후보를 넣어둠
        ArrayList<Pair> temp = new ArrayList<>();
  
				for (int i=1; i<=h; i++) {
            for (int j=1; j<=w-1; j++) {
                if (garo[i][j] != 0) continue;
                if (garo[i][j+1] != 0) continue;
                temp.add(new Pair(i,j));
            }
        }
				// 배열로 변환하기
        Pair[] a = temp.toArray(new Pair[temp.size()]);
        int ans = -1;
        if (go()) {
            System.out.println(0);
            System.exit(0);
        }
				// 각각의 후보에서 0, 1, 2, 3 형식으로 선택하면서 시뮬레이션을 돌림
        int len = a.length;
        for (int i=0; i<len; i++) {
            int x1 = a[i].first;
            int y1 = a[i].second;
						// 일관성을 위해 넣어줌
            if (garo[x1][y1] != 0 || garo[x1][y1+1] != 0) continue;
            garo[x1][y1] = 1;
            garo[x1][y1+1] = 2;
            if (go()) {
                if (ans == -1 || ans > 1) {
                    ans = 1;
                }
            }
            for (int j=i+1; j<len; j++) {
                int x2 = a[j].first;
                int y2 = a[j].second;
                // 기존의 상황이 달라짐, 위에서 1개의 가로선을 추가했기 때문에 한번 확인해야함
								if (garo[x2][y2] != 0 || garo[x2][y2+1] != 0) continue;
                garo[x2][y2] = 1;
                garo[x2][y2+1] = 2;
                if (go()) {
                    if (ans == -1 || ans > 2) {
                        ans = 2;
                    }
                }
                for (int k=j+1; k<len; k++) {
                    int x3 = a[k].first;
                    int y3 = a[k].second;
                    if (garo[x3][y3] != 0 || garo[x3][y3+1] != 0) continue;
                    garo[x3][y3] = 1;
                    garo[x3][y3+1] = 2;
                    if (go()) {
                        if (ans == -1 || ans > 3) {
                            ans = 3;
                        }
                    }
										// 초기화
                    garo[x3][y3] = 0;
                    garo[x3][y3+1] = 0;
                }
                garo[x2][y2] = 0;
                garo[x2][y2+1] = 0;
            }
            garo[x1][y1] = 0;
            garo[x1][y1+1] = 0;
        }
        System.out.println(ans);
    }
}