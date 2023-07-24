import java.io.*;
import java.util.*;


public class Main {

    static boolean[] check = new boolean[1001];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n-i; j++) {
                for (int k=0; k<=n-(i+j); k++) {
                    int l = n - (i + j + k);
                    int number = 1*i + 5*j + 10*k + 50*l;
                    check[number] = true;
                }
            }
        }

        int ans = 0;
        for (int i=0; i<1001; i++) {
            if (check[i]) ans++;
        }

        System.out.println(ans);
    }
}