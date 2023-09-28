import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
            int ans = 0;

            Stack<Integer> stack = new Stack<>();
            int number = 0;

            for (int i=0; i<s.length(); i++) {
                // option
                if (s.charAt(i) == '*' || s.charAt(i) == '#') {

                    // 이 부분이 오류날 확률 높음
                    if (s.charAt(i) == '*') {
                        int[] a = new int[2];
                        Arrays.fill(a, -1);
                        for (int j=0; j<2; j++) {
                            if (!stack.isEmpty()) {
                                int k = stack.pop();
                                k *= 2;
                                a[j] = k;
                            }
                        }

                        for (int j=1; j>=0; j--) {
                            if (a[j] != -1) {
                                stack.add(a[j]);
                            }
                        }
                    } else {
                        if (!stack.isEmpty()) {
                            int k = stack.pop();
                            k *= -1;
                            stack.add(k);
                        }
                    }
                    // bonus
                }else if (s.charAt(i) == 'S' || s.charAt(i) == 'D' || s.charAt(i) == 'T') {
                    int bonus = 0;
                    if (s.charAt(i) == 'S') {
                        bonus = 1;
                    } else if (s.charAt(i) == 'D') {
                        bonus = 2;
                    } else {
                        bonus = 3;
                    }

                    number = (int)Math.pow(number, bonus);
                    stack.add(number);
                    // init
                    number = 0;
                    // number
                } else {
                    number = number * 10 + (s.charAt(i)-'0');
                }
            }

            while (!stack.isEmpty()) {
                ans += stack.pop();
            }


            return ans;
    }
}