import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            queue.add(i);
        }
        
        int i = 0;
        int answer = 0;
        while (i < order.length) {
            int now = order[i];
            if (queue.isEmpty()) {
                if (now == stack.peek()) {
                    stack.pop();
                    answer++;
                    i++;
                } else {
                    break;
                }
            } else {
                if (now > queue.peek()) {
                    stack.push(queue.poll());
                }
                else if (now == queue.peek()) {
                    queue.poll();
                    answer++;
                    i++;
                } else {
                    if (now == stack.peek()) {
                        stack.pop();
                        answer++;
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        return answer;
    }
}