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

class Info implements Comparable<Info> {
    double cost;
    double dist;

    Info(double cost, double dist) {
        this.cost = cost;
        this.dist = dist;
    }

    double getValue() {
        return dist / cost;
    }


    @Override
    public int compareTo(Info o) {
        if (this.getValue() < o.getValue()) {
            return 1;
        } else if (this.getValue() == o.getValue()) {
            if (this.cost > o.cost) {
                return 1;
            } else if (this.cost == o.cost) {
                if (this.dist < o.dist) {
                    return 1;
                } else if (this.dist == o.dist) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
public class Main {

    /**
     접근법

     그리디,
     주유비가 가장 낮고 목적지로 부터 가장 먼 위치에 있는 도시에서 주유하기
     즉, 가치가 가장 높은 곳에서 몽땅 주유하기
     그게 아닌 경우 최소한 리터만 충전하기
     최소한 리터는 다음 위치로 이동하기위한 양을 의미

     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // 입력값 받기
        // 도시 개수, 도시 간 거리, 도시 주유비
        // 정답 기록
        int n = Integer.parseInt(br.readLine());

        String[] line1 = br.readLine().split(" ");
        int[] dist = new int[n-1];
        for (int i=0; i<n-1; i++) {
            dist[i] = Integer.parseInt(line1[i]);
        }

        String[] line2 = br.readLine().split(" ");
        int[] city = new int[n];
        for (int i=0; i<n; i++) {
            city[i] = Integer.parseInt(line2[i]);
        }

        double totalCost = 0;
        double totalDist = 0;
        for (int i=0; i<n-1; i++) {
            totalDist += dist[i];
        }

        List<Info> information = new ArrayList<>();
        double leftDist = totalDist;
        for (int i=0; i<n; i++) {
            if (i != 0) {
                leftDist -= dist[i-1];
            }
            information.add(new Info(city[i], leftDist));
        }
        // 가치 기준으로 정렬
        Collections.sort(information);
        // 가치가 가장 높은 정보
        Info target = information.get(0);


        // 그리디
        // 가장 가치가 높은 곳까지 도달하는게 목표
        // 최소 비용으로 경유하다가 해당 도시(가치가 가장 높은 곳)에 도달하면 몽땅 주유하기
        for (int i=0; i<n-1; i++) {
            // 가치가 가장 높은 지역 방문한 경우
            if (target.cost == city[i]) {
                totalCost += city[i] * totalDist;
                break;
            }
            totalCost += city[i] * dist[i];
            totalDist -= dist[i];

        }

        // 결과 출력
        System.out.println((int)totalCost);


    }
}

