import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, LocalDateTime> map = new HashMap<>();

        int y = Integer.parseInt(today.split("[.]")[0]);
        int m = Integer.parseInt(today.split("[.]")[1]);
        int d = Integer.parseInt(today.split("[.]")[2]);

        for (String t : terms) {
            String[] tmp = t.split(" ");

            int tm = m - Integer.parseInt(tmp[1]);
            int ty = y;
            while (tm < 1) {
                tm += 12;
                ty--;
            }

            map.put(tmp[0], LocalDateTime.of(ty, tm, d, 0, 0));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            LocalDateTime pday = map.get(tmp[1]); //이전은 파기
            
            LocalDateTime day
                = LocalDateTime.of(Integer.parseInt(tmp[0].substring(0,4)),
                                  Integer.parseInt(tmp[0].substring(5,7)),
                                  Integer.parseInt(tmp[0].substring(8)), 0, 0);
            
            if (day.isAfter(pday)) {
                continue;
            }

            list.add(i + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}