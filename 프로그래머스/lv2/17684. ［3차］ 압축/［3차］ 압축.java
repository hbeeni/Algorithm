import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 1;

        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(Character.toString(i), index++);
        }

        int start = 0;
        int end = 2;
        while (true) {
            while (end <= msg.length()) {
                if (!map.containsKey(msg.substring(start, end))) {
                    break;
                }
                end++;
            }

            if (end > msg.length()) {
                list.add(map.get(msg.substring(start)));
                break;
            }

            map.put(msg.substring(start, end), index++);
            list.add(map.get(msg.substring(start, end - 1)));
            start = end - 1;
            end = start + 2;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}