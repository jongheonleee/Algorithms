import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int[] r = new int[n], c = new int[n];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            r[i] = Integer.parseInt(line[0]);
            c[i] = Integer.parseInt(line[1]);
        }

        int ans = 0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int r1 = r[i], c1 = c[i];
                int r2 = r[j], c2 = c[j];

                for (int rot1=0; rot1<2; rot1++) {
                    for (int rot2=0; rot2<2; rot2++) {
                        if (r1+r2<=h && Math.max(c1, c2)<=w) {
                            int s = (r1*c1) + (r2*c2);
                            if (ans < s) ans = s;
                        }

                        if (Math.max(r1, r2)<=h && c1+c2<=w) {
                            int s = (r1*c1) + (r2*c2);
                            if (ans < s) ans = s;
                        }
                        int t2 = r2;
                        r2 = c2; c2 = t2;
                    }
                    int t1 = r1;
                    r1 = c1; c1 = t1;
                }

            }
        }
        System.out.println(ans);
    }
}