import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        char[] dart = dartResult.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < dart.length; i++) {
            char c = dart[i];
            
            if (c >= '0' && c <= '9') {
                if (dart[i + 1] == '0') {
                    stack.push(10);
                    i++;
                } else {
                    stack.push(c - '0');
                }
                
            } else {
                int cur = stack.pop();
                
                if (c == 'S') {
                    stack.push(cur);
                } else if (c == 'D') {
                    stack.push(cur * cur);
                } else if (c == 'T') {
                    stack.push(cur * cur * cur);
                } else if (c == '*') {
                    if (!stack.empty()) {
                        int prev = stack.pop();
                        stack.push(prev * 2);
                    }
                    
                    stack.push(cur * 2);
                } else if (c == '#') {
                    stack.push(cur * -1);
                }   
            }
        }
        
        while (!stack.empty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}