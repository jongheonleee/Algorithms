import java.io.*;
import java.util.Stack;

public class Main {

    // main 메서드는 프로그램의 전체 흐름이 명시되는 것이 좋음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 각각에 테스트 케이스에 대해 solve() 메서드를 호출하여
        // 올바른 괄호 형식 여부를 판단함
        for (int i=0; i<N; i++) {
            sb.append(solve(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    // 실질적인 문제 해결 코드가 담겨있는 부분
    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            }

            else if (stack.empty()){
                return "NO";
            }

            else {
                stack.pop();
            }
        }

        if (stack.empty()) {
            return "YES";
        }

        else {
            return "NO";
        }
    }

}
