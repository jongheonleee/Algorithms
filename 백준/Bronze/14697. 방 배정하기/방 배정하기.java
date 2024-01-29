import java.util.*;
import java.io.*;
import java.util.Map.Entry;


public class Main {
    private static int n;
    private static int ans;
    private static int[] room;
    

    //  배정된 모든 방에 빈 침대가 없도록 방 배정이 가능한지를 결정하는 프로그램을 작성하시오.
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 세팅
        String[] line = br.readLine().split(" ");
        room = new int[3];
        for (int i=0; i<3; i++) {
            room[i] = Integer.parseInt(line[i]);
        }
        n = Integer.parseInt(line[3]);

        // 1. 방을 선택하는 모든 경우
            // 1-0. 각 방의 침대수로 나누어 떨어지는지 확인
            // 1-1. 나누어 떨어지면 체크
        for (int i=0; i<=50; i++) {
            for (int j=0; j<=50; j++) {
                for (int l=0; l<=50; l++) {
                    if (room[0] * i + room[1]*j + room[2] * l == n) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);

    }
}

