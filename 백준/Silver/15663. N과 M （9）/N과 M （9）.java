import java.util.*;
class Result implements Comparable<Result> {
    Integer[] a;
    Result(ArrayList<Integer> a) {
        this.a = a.toArray(new Integer[a.size()]);
    }
		// 배열 a에서 idx의 원소 조회
    int get(int index) {
        return (int)this.a[index];
    }
		// 비교 메서드, 전달 인자의 배열과 해당 인스턴스 배열이 같은지 다른지 판단
		// 같으면 -> true, 다르면 -> false
    @Override
    public boolean equals(Object obj) {
				// 전달 인자가 Result의 인스턴스일 경우
        if (obj instanceof Result) {
						// Result로 형변환
            Result that = (Result)obj;
            int n = this.a.length;
						// 배열 a 탐색
            for (int i=0; i<n; i++) {
								// a[i] 값과 전달 인자의 a[i] 값이 다른 경우 
                if (this.a[i] != that.a[i]) {
										// false 반환
                    return false;
                }
            }
						// 모든 원소가 같은 경우 true
            return true;
        }
				// 전달 인자가 Result의 인스턴스가 아닌 경우
				else {
            return false;
        }
    }
		// 전달 인자의 배열과 해당 인스턴스 배열의 값의 관계 반환
		// 모두 같으면 0, 
		// 전달 인자의 배열을 that.a[i], 인스턴스 배열을 that.a[i]라고 가정
		// this.a[i] > that.a[i] : 1, this.a[i] < that.a[i] : -1
    public int compareTo(Result that) {
        int n = this.a.length;
        for (int i=0; i<n; i++) {
            if (this.a[i] == that.a[i]) continue;
            if (this.a[i] < that.a[i]) return -1;
            if (this.a[i] > that.a[i]) return 1;
        }
        return 0;
    }
}
public class Main {
		// 사용했는지 체크하는 배열 c[i] = true 사용했음을 의미함
    static boolean[] c = new boolean[10];
		// 
    static int[] a = new int[10];
		// 문제에서 제시한 수열 저장 배열
    static int[] num = new int[10];
		// 결과 수열을 담아두는 배열
    static ArrayList<Result> d = new ArrayList<>();

    static void go(int index, int n, int m) {
        if (index == m) {
            ArrayList<Integer> temp = new ArrayList<>();
            // 0~m까지
						for (int i=0; i<m; i++) {
                temp.add(num[a[i]]);
            }
						// 정답이 되는 수열을 d에 담아두기
            d.add(new Result(temp));
            return;
        }
				
        for (int i=0; i<n; i++) {
						// 이미 사용한 경우 건너뛰기
            if (c[i]) continue;
						// 체킹(사용)
            c[i] = true;
						// 
            a[index] = i;
						// 재귀호출
            go(index+1, n, m);
						// 재귀호출 종료시 초기화해주기
            c[i] = false;
        }
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
				// num에 문제에서 제시한 수열 저장하기
        for (int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
				// num 배열 정렬해주기
        Arrays.sort(num, 0, n);
				// 재귀호출 시작
        go(0, n, m);
				// d 배열 정렬하기
        Collections.sort(d);
        StringBuilder sb = new StringBuilder();
				// d 배열 순회, 현재 d는 동적 배열이며 원소 타입은 Result임
        for (int i=0; i<d.size(); i++) {
						// 인덱스 0 이거나 d에 저장된 수열들이 같지 않은 경우
            if (i == 0 || !d.get(i).equals(d.get(i-1))) {
								// d에 저장된 수열의 각 요소에 접근해서 sb에 입력해주기
                for (int j=0; j<m; j++) {
                    sb.append(d.get(i).get(j));
                    if (j != m-1) sb.append(' ');
                }
								// 다 입력했으면 줄 바꿈해주기
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}