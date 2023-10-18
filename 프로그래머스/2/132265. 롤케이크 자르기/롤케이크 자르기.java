import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        for (int current : topping) {
            left.put(current, left.getOrDefault(current, 0) + 1);
            if (right.get(current) == 1) {
                right.remove(current);
            } else {
                right.put(current, right.get(current) - 1);
            }
            if (left.size() == right.size()) {
                answer++;
            }
        }
        return answer;
    }
}