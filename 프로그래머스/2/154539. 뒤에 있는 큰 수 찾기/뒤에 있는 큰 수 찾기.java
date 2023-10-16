import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(numbers[numbers.length - 1]);
        answer[numbers.length - 1] = -1;
        
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] > deque.peekLast()) {
                answer[i] = -1;
                deque.clear();
                deque.add(numbers[i]);
                continue;
            } 
            
            while (!deque.isEmpty() && numbers[i] >= deque.peekFirst()) {
                deque.pollFirst();
            }
            if (deque.isEmpty()) {
                answer[i] = -1;
                deque.add(numbers[i]);
            } else {
                answer[i] = deque.peekFirst();
                deque.addFirst(numbers[i]);
            }
        }
        
        return answer;
    }
}