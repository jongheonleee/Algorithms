import java.io.*;
import java.util.*;



public class Main {



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        int x = Integer.parseInt(line[3]);
        int y = Integer.parseInt(line[4]);
        
        
        int price = 0;
        while (x>0 && y>0) {
            if (a+b >= 2*c) {
                price += 2*c;
            } else {
                price += a+b;
            }
            x--;
            y--;
        }
        
        while (x>0) {
            if (a >= 2*c) {
                price += 2*c;
            } else {
                price += a;
            }
            x--;
        }
        
        while (y>0) {
            if (b >= 2*c) {
                price += 2*c;
            } else {
                price += b;
            }
            y--;
        }

        System.out.println(price);

    }
}