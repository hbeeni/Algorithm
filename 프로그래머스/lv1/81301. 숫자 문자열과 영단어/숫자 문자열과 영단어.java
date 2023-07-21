import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= '0' && ch <= '9') {
                answer.append(ch);
            } else {
                String strNum = "";
                
                while (true) {
                    strNum += ch;
                    
                    if (map.get(strNum) != null) {
                        answer.append(map.get(strNum));
                        break;
                    }
                    
                    ch = s.charAt(++i);
                }
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
}