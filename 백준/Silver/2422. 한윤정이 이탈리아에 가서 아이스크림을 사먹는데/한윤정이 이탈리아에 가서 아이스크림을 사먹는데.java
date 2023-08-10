import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] notRecommend = new boolean[n+1][n+1];
        for (int i=0; i<m; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            notRecommend[x][y] = notRecommend[y][x] = true;
        }

        int ans = 0;
        for (int i=1; i<=n-2; i++) {
            for (int j=i+1; j<=n-1; j++) {
                for (int l=j+1; l<=n; l++) {
                    if (notRecommend[i][j] || notRecommend[j][l] || notRecommend[l][i]) continue;
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}