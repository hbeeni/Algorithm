//https://mag1c.tistory.com/276

package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤_고르기 {
    public static int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((t1, t2) -> map.get(t2).compareTo(map.get(t1)));

        int answer = 0;
        for (int i : keyList) {
            k -= map.get(i);
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //3
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //2
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})); //1
    }
}
