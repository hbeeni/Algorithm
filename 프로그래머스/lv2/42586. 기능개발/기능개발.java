import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        int pointer = 0;

        for (int progress : progresses) {
            queue.add(progress);
        }
        
        while (!queue.isEmpty()) {
            int node = 100 - queue.poll();
            int day = node / speeds[pointer] + (node % speeds[pointer] == 0 ? 0 : 1);
            int count = 1;
            pointer++;

            while (!queue.isEmpty()) {
                int remain = 100 - queue.peek();
                boolean possible = speeds[pointer] * day >= remain;
                if (possible) {
                    count++;
                    pointer++;
                    queue.poll();
                } else {
                    break;
                }
            }
            
            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}