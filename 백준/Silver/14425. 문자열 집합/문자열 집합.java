import java.io.*;
import java.util.*;



public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            set.add(str);
        }

        int ans = 0;
        for (int i=0; i<m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}