import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("Enter", "님이 들어왔습니다.");
        statusMap.put("Leave", "님이 나갔습니다.");
        
        Map<String, String> idMap = new HashMap<>();
        for (String str : records) {
            String[] record = str.split(" ");
            if (!record[0].equals("Leave")) {
                idMap.put(record[1], record[2]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String str : records) {
            String[] record = str.split(" ");
            if (!record[0].equals("Change")) {
                answer.add(idMap.get(record[1]) + statusMap.get(record[0]));
            }
        }

        return answer.stream()
                .toArray(String[]::new);
    }
}