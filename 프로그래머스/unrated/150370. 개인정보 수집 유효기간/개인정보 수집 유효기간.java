import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int day = getDay(today);

        for (String term : terms) {
            String[] tmp = term.split(" ");
            termMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");

            if ((getDay(tmp[0]) + termMap.get(tmp[1]) * 28) > day) {
                continue;
            }

            list.add(i + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    static int getDay(String date) {
        int y = Integer.parseInt(date.split("[.]")[0]);
        int m = Integer.parseInt(date.split("[.]")[1]);
        int d = Integer.parseInt(date.split("[.]")[2]);

        return y * 12 * 28 + m * 28 + d;
    }
}