//https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1918-%ED%9B%84%EC%9C%84-%ED%91%9C%EA%B8%B0%EC%8B%9D-JAVA%EC%9E%90%EB%B0%94

package baekjoon.algorithm_basic_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            switch (now) {
                //현재 연산자보다 연산자 스택에 담아둔 연산자의 우선순위가 높거나 같으면 먼저 출력
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!opStack.empty() && priority(opStack.peek()) >= priority(now)) {
                        sb.append(opStack.pop());
                    }

                    opStack.add(now);
                    break;

                //스택에 담음
                case '(':
                    opStack.add(now);
                    break;

                //'('가 나올때까지 스택에 담아둔 연산자를 모두 꺼내서 출력 후 '('는 출력하지 않고 꺼내줌
                case ')':
                    while (!opStack.empty() && opStack.peek() != '(') {
                        sb.append(opStack.pop());
                    }

                    opStack.pop();
                    break;

                //문자가 들어오면 그대로 출력
                default:
                    sb.append(now);
            }
        }

        while (!opStack.isEmpty()) {
            sb.append(opStack.pop());
        }

        System.out.println(sb);
    }

    //연산자 별 우선순위 리턴 (클수록 높은 우선순위)
    private static int priority(char operator) {
        switch (operator) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;
    }
}
