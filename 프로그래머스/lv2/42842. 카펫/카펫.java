//https://yongku.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B9%B4%ED%8E%AB-%EC%9E%90%EB%B0%94JAVA

import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow; //전체 타일 개수

        for (int i = 1; i <= sum; i++) {
            int row = i;
            int col = sum / row;

            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }

        return answer;
    }
}