//정답 보고 조금 수정

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //answer 초기화 = 전체 학생 수 - lost 길이
        int answer = n - lost.length;

        //Set에 reserve 넣기
        Set<Integer> set = new HashSet<>();
        for (int i : reserve) {
            set.add(i);
        }

        //lost 정렬
        Arrays.sort(lost);

        /*
        for (0 ~ lost 길이)
            여벌 체육복이 있는 학생이 lost 배열에 있으면
                answer++
                Set에서 remove
                값을 -1로 변경
         */
        for (int i = 0; i < lost.length; i++) {
            if (set.contains(lost[i])) {
                answer++;
                set.remove(lost[i]);
                lost[i] = -1;
            }
        }

        /*
        for (0 ~ lost 길이)
            lost 배열 원소가 -1이면
                continue;
            lost 배열 원소의 앞 뒤가 Set에 있으면
                answer++
                빌려준 학생을 Set에서 remove
         */
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) {
                continue;
            }
            if (set.contains(lost[i] - 1)) {
                answer++;
                set.remove(lost[i] - 1);
            } else if (set.contains(lost[i] + 1)) {
                answer++;
                set.remove(lost[i] + 1);
            }
        }

        return answer;
    }
}