import java.util.*;

class Pair implements Comparable<Pair> {
    final int first;
    final int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair pair) {
            if (this.first < pair.first) {
                return -1;
            }
            if (this.first > pair.first) {
                return 1;
            }
            if (this.second < pair.second) {
                return -1;
            }
            if (this.second > pair.second) {
                return 1;
            }
            return 0;
        }

    public boolean equals(Object object) {
        if (object instanceof Pair) {
            Pair pair = (Pair)object;
            return this.first == pair.first && this.second == pair.second;
        }
        return false;
    }

    public int hashCode() {
        int n = 3;
        n = 19 * n + this.first;
        n = 19 * n + this.second;
        return n;
    }
}
public class Main {
		// 물을 옮길 수 있는 방향이 총 6가지
		// from에서 to로 물을 붓는 경우
    public static final int[] from = {0, 0, 1, 1, 2, 2};
    public static final int[] to = {1, 2, 0, 2, 0, 1};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
				// 물통의 용량
        int[] cap = new int[3];
        for (int i=0; i<3; i++) {
            cap[i] = sc.nextInt();
        }
        int sum = cap[2];
        boolean[][] check = new boolean[201][201];
				// A가 비어있을때, C의 물이 i 만큼 들어가 있는 것이 가능한지 여부기록 
        boolean[] ans = new boolean[201];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
        check[0][0] = true;
        ans[cap[2]] = true;
        while (!q.isEmpty()) {
						// 현재 물통의 상태
            int[] cur = new int[3];
            Pair p = q.peek();
            cur[0] = p.first;
            cur[1] = p.second;
            cur[2] = sum - cur[0] - cur[1];
            q.remove();
            for (int k=0; k<6; k++) {
                int[] next = {cur[0], cur[1], cur[2]};
								// 일단 물을 다 담아두기
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;
								// 제한 용량을 넘어간 경우
                if (next[to[k]] >= cap[to[k]]) {
                    next[from[k]] = next[to[k]] - cap[to[k]];
                    next[to[k]] = cap[to[k]];
                }
								// 방문 표시해주기 (a, b)
                if (!check[next[0]][next[1]]) {
                    check[next[0]][next[1]] = true;
                    q.add(new Pair(next[0], next[1]));
										// A의 용량이 0인 경우 정답 표시
                    if (next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
        for (int i=0; i<=cap[2]; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}