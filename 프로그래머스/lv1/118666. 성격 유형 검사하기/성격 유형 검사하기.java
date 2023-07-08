import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        String[] types = {"RT", "CF", "JM", "AN"};
        int[] type = {0, 0, 0, 0, 0, 1, 1, 1};
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        
        for (int i = 0; i < choices.length; i++) {
            char key = survey[i].charAt(type[choices[i]]);
            scoreMap.put(key, scoreMap.getOrDefault(key, 0) + scores[choices[i]]);
        }
        
        String answer = "";
        
        for (int i = 0; i < types.length; i++) {
            int front = scoreMap.getOrDefault(types[i].charAt(0), 0);
            int back = scoreMap.getOrDefault(types[i].charAt(1), 0);
            
            if (front >= back) {
                answer += types[i].charAt(0);
            } else {
                answer += types[i].charAt(1);
            }
        }
        
        return answer;
    }
}