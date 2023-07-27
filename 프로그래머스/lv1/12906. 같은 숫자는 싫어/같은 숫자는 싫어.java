import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (queue.peekLast() != arr[i]) {
                queue.add(arr[i]);
            }
        }

        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}