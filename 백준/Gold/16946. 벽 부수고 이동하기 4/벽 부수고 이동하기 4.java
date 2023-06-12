import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] a;
    // 방문 여부
    static boolean[][] check;
    // 각 위치의 그룹을 매김
    static int[][] group;
    // 각 그룹에 해당하는 영역의 사이즈
    static ArrayList<Integer> group_size = new ArrayList<>();
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    
    
    // 시작점을 받아옴
    static void bfs(int sx, int sy) {
        // g는 그룹의 개수를 나타냄. 처음에는 0개부터 시작 추후에 bfs 호출되고 나서 1개씩 추가됨
        // 따라서 각각의 그룹을 0, 1, 2, ,,,로 표현
        int g = group_size.size();
        Queue<Integer> q = new LinkedList<>();
        
        // 시작점 넣기
        q.add(sx); q.add(sy);
        check[sx][sy] = true;
        group[sx][sy] = g;
        int cnt = 1;
        
        // bfs 알고리즘 적용
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 0 && check[nx][ny] == false) {
                        q.add(nx); q.add(ny);
                        check[nx][ny] = true;
                        group[nx][ny] = g;
                        // 영역 크기 증가
                        cnt += 1;
                    }
                }
            }
        }
        // 해당 그룹의 사이즈 추가
        group_size.add(cnt);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = bf.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        a = new int[n][m];
        check = new boolean[n][m];
        group = new int[n][m];
        
        for (int i=0; i<n; i++) {
            String s = bf.readLine();
            for (int j=0; j<m; j++) {
                a[i][j] = s.charAt(j) - '0';
                check[i][j] = false;
                group[i][j] = -1;
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && check[i][j] == false) {
                    bfs(i, j);
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0) {
                    bw.write("0");
                } else {
                    HashSet<Integer> near = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            if (a[x][y] == 0) {
                                near.add(group[x][y]);
                            }
                        }
                    }
                    
                    int ans = 1;
                    for (int g : near) {
                        ans += group_size.get(g);
                    }
                    
                    bw.write(String.valueOf(ans%10));
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}