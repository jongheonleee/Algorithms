import java.io.*;
import java.util.*;

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}



public class Main {

    static long calc(long n) {
        return n*(n+1)/2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        int[] leftGrater = new int[n+1];
        int[] rightGrater = new int[n+1];
        int[] leftSmaller = new int[n+1];
        int[] rightSmaller = new int[n+1];

        String[] line = br.readLine().split(" ");

        for(int i=1; i<=n; i++) {
            a[i] = Integer.parseInt(line[i-1]);
            leftGrater[i] = leftSmaller[i] = 0;
            rightGrater[i] = rightSmaller[i] = n+1;
        }

        {
            Stack<Pair> stackGrater = new Stack<>();
            Stack<Pair> stackSmaller = new Stack<>();

            stackGrater.push(new Pair(1, a[1]));
            stackSmaller.push(new Pair(1, a[1]));

            for (int i=2; i<=n; i++) {
                while (!stackGrater.isEmpty() && a[i] >= stackGrater.peek().second) {
                    rightGrater[stackGrater.peek().first] = i;
                    stackGrater.pop();
                }
                stackGrater.push(new Pair(i, a[i]));

                while (!stackSmaller.isEmpty() && a[i] <= stackSmaller.peek().second) {
                    rightSmaller[stackSmaller.peek().first] = i;
                    stackSmaller.pop();
                }
                stackSmaller.push(new Pair(i, a[i]));
            }
        }

        {
            Stack<Pair> stackGrater = new Stack<>();
            Stack<Pair> stackSmaller = new Stack<>();

            stackGrater.push(new Pair(n, a[n]));
            stackSmaller.push(new Pair(n, a[n]));

            for (int i=n-1; i>=1; i--) {
                while (!stackGrater.isEmpty() && a[i] > stackGrater.peek().second) {
                    leftGrater[stackGrater.peek().first] = i;
                    stackGrater.pop();
                }
                stackGrater.push(new Pair(i, a[i]));

                while (!stackSmaller.isEmpty() && a[i] < stackSmaller.peek().second) {
                    leftSmaller[stackSmaller.peek().first] = i;
                    stackSmaller.pop();
                }
                stackSmaller.push(new Pair(i, a[i]));
            }

        }

        long ans = 0;
        for (int i=1; i<=n; i++) {
            int left = Math.min(i, leftGrater[i]+1);
            int right = Math.max(i, rightGrater[i]-1);
            long len = right-left+1;
            ans += (calc(len) - calc(right-i) - calc(i-left)) * a[i];
        }

        for (int i=1; i<=n; i++ ) {
            int left = Math.min(i, leftSmaller[i]+1);
            int right = Math.max(i, rightSmaller[i]-1);
            long len = right-left+1;
            ans -= (calc(len) - calc(right-i) - calc(i-left)) * a[i];
        }

        System.out.println(ans);
        
    }
}