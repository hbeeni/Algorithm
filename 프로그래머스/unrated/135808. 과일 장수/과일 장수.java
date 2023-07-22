import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        //사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score
        int answer = 0;
        Arrays.sort(score);

        for (int i = score.length - 1; i >= 0; i -= m) {
            if (i - m + 1 >= 0) {
                answer += score[i - m + 1] * m;
            }
        }
        
        return answer;
    }
}