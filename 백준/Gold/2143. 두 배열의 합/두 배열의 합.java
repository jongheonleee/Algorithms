import java.util.*;
import java.io.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<m; i++) {
            b[i] = Integer.parseInt(line2[i]);
        }

        ArrayList<Integer> sum1 = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int k=i; k<n; k++) {
                sum += a[k];
                sum1.add(sum);
            }
        }

        ArrayList<Integer> sum2 = new ArrayList<>();
        for (int i=0; i<m; i++) {
            int sum = 0;
            for (int k=i; k<m; k++) {
                sum += b[k];
                sum2.add(sum);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int s : sum2) {
            if (map.containsKey(s)) {
                int tmp = map.get(s);
                map.put(s, tmp+1);
            } else {
                map.put(s, 1);
            }
        }

        long ans = 0;
        for (int s : sum1) {
            int target = t - s;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
        }

        System.out.println(ans);

    }
}