//https://geonoo.tistory.com/63

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        int[] answer = new int[N];

        for (int i = 1; i <= N; i++) {
            double total = 0;
            double fail = 0;

            for (int j = 0; j < stages.length; j++) {
                if (i <= stages[j]) {
                    total++;
                }
                if (i == stages[j]) {
                    fail++;
                }
            }

            map.put(i, total == 0 ? 0 : fail / total);
        }

        for (int i = 0; i < N; i++) {
            double max = -1;
            int stage = 0;

            for (Integer key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    stage = key;
                }
            }

            answer[i] = stage;
            map.remove(stage);
        }

        return answer;
    }
}