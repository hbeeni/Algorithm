import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : scoville) {
            queue.add(n);
        }

        int answer = 0;
        while (queue.peek() < K) {
            if (queue.size() >= 2) {
                int n1 = queue.poll();
                int n2 = queue.poll();
                queue.add(n1 + n2 * 2);
                answer++;
            } else {
                return -1;
            }
        }
        
        return answer;
    }
}