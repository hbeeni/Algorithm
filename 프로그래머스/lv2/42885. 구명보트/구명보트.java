import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int person : people) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        for (int current : map.keySet()) {
            int another = limit - current;

            while (map.get(current) > 0) {
                if (another < 40) {
                    answer += map.get(current);
                    map.put(current, 0);
                    break;
                }
                if (current == another) {
                    answer += map.get(current) / 2;
                    map.put(current, map.get(current) % 2);
                } else if (map.containsKey(another) && map.get(another) > 0) {
                    while (map.get(another) > 0 && map.get(current) > 0) {
                        answer++;
                        map.put(another, map.get(another) - 1);
                        map.put(current, map.get(current) - 1);
                    }
                }

                another--;
            }
        }

        return answer;
    }
}