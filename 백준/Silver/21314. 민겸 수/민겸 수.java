import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
문제 요약

 */

public class Main {

    /**
     접근법

     그리디, 스택
     MM,,, -> 길이가 n일 때의 최소값
     MM,,K -> 길이가 n일 때의 최대값

     최소값 : K 바로 앞에 M의 가장 큰 뭉터기를 계산, k는 바로 5로 계산
     최대값 : k 까지, 바로 앞의 M의 가장 큰 뭉터기와 합쳐서 계산

     문자열을 총 두 번 돌림, 최소/최대 구하기
     스택 2개 사용
     첫 번째 스택은 최소, M을 계속 담다가 K 만나면 그 안에 있는거 꺼내서 10^n, 그리고 K는 5로 계산해서 붙이기 위 과정 반복
     두 번째 스택은 최대, M을 계속 담다가 K 까지 담고 그 안에 있는거 꺼내서 10^n * 5, 위 과정 반복
     출력

     */

    // MAX 계산
    // 각 문자 순회
    // M 인 경우 curr 1 추가
    // K 인 경우 curr * 5, max에 붙이기
    // curr 남은 경우 max에 붙이기
    private static String calculateMax(String str) {
        StringBuilder sb = new StringBuilder();
        String curr = "";

        for (char ch : str.toCharArray()) {
            if (ch == 'M') {
                curr += "1";
            } else {
                String tmp = "";
                if (curr.length() > 0) {
                    for (int i=0; i<curr.length()+1; i++) {
                        if (i == 0) tmp += "5";
                        else tmp += "0";
                    }
                } else {
                    tmp += "5";
                }
                sb.append(tmp);
                curr = "";
            }
        }

        if (curr.length() > 0) {
            sb.append(curr);
        }

        return sb.toString();
    }

    // MIN 계산
    // 각 문자 순회
    // M 인 경우 curr 1 추가
    // K 인 경우 curr을 min에 이어 붙이기, 5도 이어 붙임
    // curr 남은 경우 min에 이어 붙이기
    private static String calculateMin(String str) {
        StringBuilder sb = new StringBuilder();
        String curr = "";

        for (char ch : str.toCharArray()) {
            if (ch == 'M') {
                if (curr.length() > 0) {
                    curr += "0";
                } else {
                    curr += "1";
                }
            } else {
                sb.append(curr);
                sb.append("5");
                curr = "";
            }
        }

        if (curr.length() > 0) {
            sb.append(curr);
        }

        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        String line = br.readLine();
        String max = calculateMax(line);
        String min = calculateMin(line);

        // 결과 출력
        System.out.println(max);
        System.out.println(min);

    }
}
