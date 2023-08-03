import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (int i = 0; i < s.length(); i++) {
            int index = i;

            for (int j = 0; j < s.length(); j++) {
                char bracket = s.charAt(index);

                if (stack.empty()) {
                    stack.push(bracket);
                } else {
                    if (stack.peek() == map.get(bracket)) {
                        stack.pop();
                    } else {
                        stack.push(bracket);
                    }
                }

                index = (index == s.length() - 1) ? 0 : index + 1;
            }

            if (stack.empty()) {
                answer++;
            } 
            
            stack.clear();
        }

        return answer;
    }
}