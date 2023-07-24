import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        Deque<String> deque = new LinkedList<>();
        deque.offer("0");

        for (int i = food.length - 1; i >= 1; i--) {
            String input = String.valueOf(i).repeat(food[i] / 2);
            deque.addFirst(input);
            deque.addLast(input);
        }

        while (!deque.isEmpty()) {
            answer += deque.poll();
        }
        
        return answer;
    }
}