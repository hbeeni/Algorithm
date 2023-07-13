import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                
                if (map.containsKey(ch)) {
                    map.put(ch, Math.min(map.get(ch), i + 1));
                } else {
                    map.put(ch, i + 1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            
            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                
                if (map.containsKey(ch)) {
                    sum += map.get(ch);
                } else {
                    sum = 0;
                    break;
                }
            }
            
            answer[i] = sum == 0 ? -1 : sum;
        }
        
        return answer;
    }
}