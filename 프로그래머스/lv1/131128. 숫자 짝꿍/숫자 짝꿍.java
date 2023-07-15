import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        int[] total = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            yCount[Y.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            total[i] = Math.min(xCount[i], yCount[i]);
        }
        
        for (int i = 9; i >= 0; i--) {
            sb.append(String.valueOf(i).repeat(total[i]));
        }
        
        String answer = sb.toString();
        
        if (answer.length() == 0) {
            answer = "-1";
        } else if (answer.charAt(0) == '0') {
            answer = "0";
        } 
        
        return answer;
    }
}