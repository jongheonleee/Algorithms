import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n+1];
        boolean[][] friend = new boolean[n+1][n+1];

        for (int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            friend[x][y] = friend[y][x] = true;
            degree[x]++; degree[y]++;
        }

        int ans = -1;
        for (int i=1; i<=n-2; i++) {
            for (int j=i+1; j<=n-1; j++) {
                if (friend[i][j] == true) {
                    for (int l=j+1; l<=n; l++) {
                        if (friend[i][l] && friend[j][l]) {
                            int res = degree[i] + degree[j] + degree[l] - 6;
                            if (ans == -1 || ans > res) ans = res;
                        }
                    }
                }
            }
        }

        System.out.println(ans);


    }
}