import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] numbers = br.readLine().toCharArray();

        int sum = 0;
        for (int i=0; i<numbers.length; i++) {
            sum += numbers[i] - '0';
        }
        Arrays.sort(numbers);
        
        if (numbers[0] == '0' && sum % 3 == 0) {
            for (int i=numbers.length-1; i>=0; i--) {
                System.out.print(numbers[i]);
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
       
    }
}