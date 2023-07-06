import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playersMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i + 1);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String back = callings[i];
            int backGrade = playersMap.get(back); //추월한 사람 등수
            String front = players[backGrade - 2]; //추월당한 사람
            
            //추월한 사람, 추월당한 사람 swap
            String tmp = players[backGrade - 1];
            players[backGrade - 1] = players[backGrade - 2];
            players[backGrade - 2] = tmp;
            
            //playersMap 업데이트
            playersMap.replace(front, backGrade);
            playersMap.replace(back, backGrade - 1);
        }
        
        return players;
    }
}