import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
문제 요약

 도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용
 각 도시에는 단 하나의 주유소가 있으며, 도시 마다 주유소의 리터당 가격은 다름
 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용

 N(2 ≤ N ≤ 100,000)
 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수
 리터당 가격은 1 이상 1,000,000,000 이하의 자연수
 */

public class Main {

    /**
     접근법

     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n-1];
        long[] cost = new long[n];
        
        String[] line1 = br.readLine().split(" ");
        for (int i=0; i<n-1; i++) {
            dist[i] = Integer.parseInt(line1[i]);
        }
        
        String[] line2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(line2[i]);
        }
        
        long sum = 0;
        long minCost = cost[0];

        for (int i=0; i<n-1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            
            sum += (minCost * dist[i]);
        }

        System.out.println(sum);
    }
}
