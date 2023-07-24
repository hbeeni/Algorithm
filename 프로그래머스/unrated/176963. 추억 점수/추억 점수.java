import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int index = 0;
        for (String[] people : photo) {
            int sum = 0;
                    
            for (String person : people) {
                sum += map.getOrDefault(person, 0);
            }
            
            answer[index++] = sum;
        }
        
        return answer;
    }
}