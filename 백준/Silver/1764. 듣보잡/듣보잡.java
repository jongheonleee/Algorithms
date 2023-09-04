import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> s1 = new HashSet<>();
        HashSet<String> s2 = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            s1.add(br.readLine());
        }

        for (int i=0; i<m; i++) {
            String name = br.readLine();
            s2.add(name);
            if (s1.contains(name)) {
                ans.add(name);
            }
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        for (String name : ans) {
            System.out.println(name);
        }



    }
}
