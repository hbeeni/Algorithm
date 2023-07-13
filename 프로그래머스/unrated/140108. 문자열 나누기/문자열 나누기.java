class Solution {
    public int solution(String s) {
        int answer = 0;
        char target = s.charAt(0);
        int same = 1, diff = 0;
        
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == target) {
                same++;
            } else {
                diff++;
            }
            
            if (same == diff) {
                answer++;
                same = diff = 0;
                
                if (i == s.length() - 1) {
                    break;
                }
                
                target = s.charAt(i + 1);
            }
        }
        
        if (same != 0) {
            answer++;
        }
        
        return answer;
    }
}