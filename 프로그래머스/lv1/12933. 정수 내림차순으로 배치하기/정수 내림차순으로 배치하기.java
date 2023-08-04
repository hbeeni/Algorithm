import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;

        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        for (int i = chars.length - 1; i >= 0; i--) {
            answer = answer * 10 + (chars[i] - '0');
        }
        
        return answer;
    }
}