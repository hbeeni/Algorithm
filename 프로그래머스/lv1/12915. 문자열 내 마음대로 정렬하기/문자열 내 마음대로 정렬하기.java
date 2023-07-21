import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Set<String>[] setArr = new Set['z' - 'a' + 1];
        int index = 0;
        
        for (int i = 0; i < setArr.length; i++) {
            setArr[i] = new TreeSet<>();
        }
        
        for (String str : strings) {
            setArr[str.charAt(n) - 'a'].add(str);
        }
        
        for (Set<String> set : setArr) {
            String[] tmp = set.toArray(String[]::new);
            
            for (int i = 0; i < tmp.length; i++) {
                answer[index++] = tmp[i];
            }
        }
        
        return answer;
    }
}