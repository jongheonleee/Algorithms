import java.util.*;
public class Main {
		// 고장난 버튼 저장
    static boolean[] broken = new boolean[10];
		// 채널을 인자로 전달받음 c
		// 고장나지 않은 버튼으로 누른 횟수
    static int possible(int c) {
				// 예외 처리 채널이 0일 때
        if (c == 0) {
            if (broken[0]) {
								// 0 버튼 못누름
                return 0;
            } else {
								// 0 버튼 누름
                return 1;
            }
        }
				// 버튼 누른 횟수 계산
        int len = 0;
				// 채널값이 0이 아닌 경우 계속 반복
        while (c > 0) {
						// 일의 자리값을 가져오고 고장났는지 확인함
            if (broken[c % 10]) {
								// 고장난 경우 끝내기 버튼 누른 횟수 0
                return 0;
            }
						// 누를 수 있는 경우 개수 1추가하기
            len += 1;
						// 해당값 10으로 나눠주기
            c /= 10;
        }
				// 만약에 버튼으로 전달받은 채널로 이동가능한 경우 얼마만큼의 버튼을 눌렀는지 반환하기
        return len;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
						// 고장난 버튼 저장
            broken[x] = true;
        }
				// 수빈이 시작 채널은 100이므로 100 빼주기
        int ans = n - 100;
        if (ans < 0) {
						// 음수인 경우 양수로 전환해주기
            ans = -ans;
        }
				// 이동 가능한 채널을 최대 1000000으로 설정하기
				// 100 기준으로 500000까지 이동하는 경우와 그 반대 경우 
				// 대략 1000000
        for (int i = 0; i <= 1000000; i++) {
						// 채널 받아오기
            int c = i;
						// 남은 길이 측정
            int len = possible(c);
						// 해당 채널로 숫자 버튼 눌러서 이동가능한 경우
            if (len > 0) {
                int press = c - n;
                if (press < 0) {
										// 음수일 때는 양수처리
                    press = -press;
                }
								// 최소값 갱신해주기
                if (ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }
}