import java.util.*;
import java.io.*;

public class Main {
    static final int LIMIT = 100000;
    static int[] dist = new int[LIMIT+1];
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int src = sc.nextInt(); int dest = sc.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        
        while (!q.isEmpty()) {
            int curr = q.remove();
            
            if (curr == dest) {
                System.out.println(dist[dest]);
                break;
            }
            
            if (curr-1 >= 0 && dist[curr-1] == 0) {
                dist[curr-1] = dist[curr]+1;
                q.add(curr-1);
            }
            
            if (curr+1 <= LIMIT && dist[curr+1] == 0) {
                dist[curr+1] = dist[curr]+1;
                q.add(curr+1);
            }
            
            if (2*curr <= LIMIT && dist[2*curr] == 0) {
                dist[2*curr] = dist[curr]+1;
                q.add(2*curr);
            }
        }
        
    }
}