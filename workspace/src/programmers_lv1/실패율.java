//https://geonoo.tistory.com/63

package programmers_lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 실패율 {

    public static int[] solution(int N, int[] stages) {
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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }
}
