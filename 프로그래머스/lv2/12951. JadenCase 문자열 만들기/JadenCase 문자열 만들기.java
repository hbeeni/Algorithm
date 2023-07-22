import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Deque<Character> q = new LinkedList<>();
        
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            q.offer(Character.toUpperCase(s.charAt(0)));
        } else {
            q.offer(s.charAt(0));
        }

        for (int i = 1; i < s.length(); i++) {
            char letter = s.charAt(i);
            
            if (q.peekLast() == ' ') {
                if (letter >= 'a' && letter <= 'z') {
                    q.offer(Character.toUpperCase(letter));
                } else {
                    q.offer(letter);
                }
            } else {
                if (letter >= 'A' && letter <= 'Z') {
                    q.offer(Character.toLowerCase(letter));
                } else {
                    q.offer(letter);
                }
            }
        }

        q.forEach(c -> answer.append(c));
        return answer.toString();
    }
}