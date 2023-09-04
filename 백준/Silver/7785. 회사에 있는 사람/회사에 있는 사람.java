import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");

            if (line[1].equals("enter")) {
                set.add(line[0]);
            } else {
                if (set.contains(line[0])) {
                    set.remove(line[0]);
                }
            }
        }

        for (String name : set) {
            ans.add(name);
        }


        Collections.sort(ans, Collections.reverseOrder());
        for (String name : ans) {
            System.out.println(name);
        }
    }
}