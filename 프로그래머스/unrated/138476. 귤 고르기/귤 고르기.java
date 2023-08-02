import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    static class TangerineCount implements Comparable<TangerineCount> {
        int value;
        int count;

        public TangerineCount(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(TangerineCount t) {
            return t.count - this.count;
        }
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<TangerineCount> queue = new PriorityQueue<>();
        for (int value : map.keySet()) {
            queue.add(new TangerineCount(value, map.get(value)));
        }

        int count = 0;
        int answer = 0;
        while (count < k) {
            TangerineCount current = queue.poll();
            count += current.count;
            answer++;
        }

        return answer;
    }
}