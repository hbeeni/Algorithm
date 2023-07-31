import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        
        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        
        return sb.toString();
    }
}