package programmers.lv2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop(); //답을 구했기 때문에 stack에서 제거
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { //아직 stack에 남아 있음 = 끝까지 가격이 떨어지지 않음
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        주식가격 s = new 주식가격();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 2, 3})));
    }
}
