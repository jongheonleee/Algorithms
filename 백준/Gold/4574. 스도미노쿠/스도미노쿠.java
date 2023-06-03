import java.util.*;
public class Main {
    static int[][] board = new int[10][10];

    // 행에 대한 정보 : i 번째 행에 num 이 있는지 없는지 확인
    // 열에 대한 정보 : j 번째 행에 num 이 있는지 없는지 확인
    // 정사각형에 대한 정보 : (i, j)를 포함하는 3*3 정사각형에 num이 있는지 없는지 확인
    
    static boolean[][][] check = new boolean[3][10][10];

    // 도미노에 대한 정보 : (i, j)로 구성된 도미노를 사용했는지 확인
    static boolean[][] domino = new boolean[10][10];

    static final int n = 9;

    // 도미노를 회전할 수 있음, 즉 가로/세로로 놓을 수 있음
    // 그 방향을 표현한 정보임
    static final int[] dx = {0, 1};
    static final int[] dy = {1, 0};

    static int square(int x, int y) {
        return (x/3)*3+(y/3);
    }

    // 해당 위치를 기준으로 행/열/정사각형에 num이 등장했는지 확인
    // 등장했었으면 false 반환
    static boolean can(int x, int y, int num) {
        return check[0][x][num] == false && check[1][y][num] == false && check[2][square(x,y)][num] == false;
    }

    // 해당 위치를 기준으로 행/열/정사각형에 num이 등장했는지 안했는지에 대한 정보를 넣어주는 메서드
    static void check(int x, int y, int num, boolean what) {
        // 행/열/정사각형에 num을 사용했다고 표시해주기
        check[0][x][num] = what;
        check[1][y][num] = what;
        check[2][square(x, y)][num] = what;
    }

    // 바운더리 내에 존재하는지 확인
    static boolean check_range(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean go(int z) {
        // 총 81칸으로 구성되어 있음
        // 모든 칸을 놓으면 결과 값 출력해주기
        if (z == 81) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            return true;
        }
        // z를 행/열의 형태로 추출하기
        int x = z/n;
        int y = z%n;
        // 이미 방문했으면 스킵하고 다음 경우 호출하기
        if (board[x][y] != 0) {
            return go(z+1);

        }
        // 위의 경우가 아니면 도미노 놓아주기
        else {
            for (int k=0; k<2; k++) {
                // 도미노를 놓을 수 있는 방법은 총 2가지(회전 가능하다고 언급함)
                // 1. 도미노를 가로 형태로 놓는 경우 -> y+1(열을 한칸 오른쪽으로 이동시킴)
                // 2. 도미노를 세로 형태로 놓는 경우 -> x+1(행을 한칸 아래로 이동시킴)
                // 즉 도미노의 위치 정보 : (x, y) && (nx, ny)
                int nx = x+dx[k];
                int ny = y+dy[k];

                // 바운더리(스도쿠 판) 내에 존재하는지 확인
                if (!check_range(nx,ny)) {
                    // 밖으로 넘어가면 해당 경우는 스킵함
                    continue;
                }

                // 해당 위치에 이미 수로 채워진 경우 스킵하기
                if (board[nx][ny] != 0) continue;

                //
                for (int i=1; i<=9; i++) {
                    for (int j=1; j<=9; j++) {
                        // 숫자가 서로 같은 경우의 도미노는 없음, 따라서 숫자가 서로 같으면 건너뜀
                        if (i == j) continue;

                        // 해당 도미노를 이미 사용한 경우
                        if (domino[i][j]) continue;

                        // (x, y)와 (nx, ny)에 각각 i, j를 놓을수 있는지 확인해보기
                        if (can(x,y,i) && can(nx,ny,j)) {
                            // 놓을수 있는 경우

                            // 세팅
                            check(x,y,i,true);
                            check(nx,ny,j,true);
                            domino[i][j] = domino[j][i] = true;
                            board[x][y] = i;
                            board[nx][ny] = j;

                            // 다음 호출
                            if (go(z+1)) {
                                return true;
                            }

                            // 초기화
                            check(x,y,i,false);
                            check(nx,ny,j,false);
                            domino[i][j] = domino[j][i] = false;
                            board[x][y] = 0;
                            board[nx][ny] = 0;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc=1;

        while (true) {
            // 초기 세팅
            for (int i=0; i<10; i++) {
                Arrays.fill(check[0][i], false);
                Arrays.fill(check[1][i], false);
                Arrays.fill(check[2][i], false);
                Arrays.fill(domino[i], false);
                Arrays.fill(board[i], 0);
            }

            int m = sc.nextInt();
            // 테스트 케이스 종료 조건
            if (m == 0) break;
            // 총 m개 입력문이 제시됨
            for (int i=0; i<m; i++) {
                // 도미노 놓아주기 작업
                // 도미노 정보 받아오기(크기가 2짜리 도미노)
                int n1 = sc.nextInt(); // 첫번째 칸에 들어가는 숫자 정보
                String s1 = sc.next(); // 첫번째 칸의 위치 정보

                int n2 = sc.nextInt(); // 두번째 칸에 들어가는 숫자 정보
                String s2 = sc.next(); // 두번째 칸의 위치 정보

                // 해당 행/열 정보 숫자로 변환해주기(위치 정보에서 인덱스 형태로 추출하기)
                int x1 = s1.charAt(0) - 'A';
                int y1 = s1.charAt(1) - '1';
                int x2 = s2.charAt(0) - 'A';
                int y2 = s2.charAt(1) - '1';

                // 해당 위치에 숫자 정보 넣어주기
                board[x1][y1] = n1;
                board[x2][y2] = n2;

                // 해당 도미노 사용했다고 체크해주기
                domino[n1][n2] = domino[n2][n1] = true;

                // 행/열/정사각형에 숫자를 사용했다고 표시해주기
                check(x1,y1,n1,true);
                check(x2,y2,n2,true);
            }


            // 도미노가 아닌 한자리 숫자 정보도 넣어주기
            for (int i=1; i<=9; i++) {
                String s = sc.next();
                // 위치 정보 받아오기
                int x = s.charAt(0) - 'A';
                int y = s.charAt(1) - '1';
                // 해당 위치에 숫자 넣어주기
                board[x][y] = i;
                // 행/열/정사각형에 숫자를 사용했다고 표시해주기
                check(x,y,i,true);
            }
            // 출력해주기
            System.out.println("Puzzle " + tc);
            // 백트랙킹 재귀 탐색을 통해 스도미노쿠를 만족하는 결과 출력하기
            go(0);
            tc += 1;
        }
    }
}