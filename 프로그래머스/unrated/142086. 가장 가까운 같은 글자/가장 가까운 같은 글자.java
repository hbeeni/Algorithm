import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] index = new int['z' - 'a' + 1];
        Arrays.fill(index, -1);

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            
            if (index[now - 'a'] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - index[now - 'a'];
            }
            
            index[now - 'a'] = i;
        }
        
        return answer;
    }
}