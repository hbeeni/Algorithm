//https://velog.io/@yanghl98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5-JAVA%EC%9E%90%EB%B0%94

package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }

        /**
         * 만약 상의 2개, 하의 3개면
         * 상의 0개/1개/2개 & 하의 0개/1개/2개/3개
         * -> 모든 의상 타입 길이 곱해서 아무것도 안 입는 1개의 경우의 수 빼주면 됨
         */
        int answer = 1;
        for (String type : map.keySet()) {
            answer *= map.get(type);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        })); //5
        System.out.println(solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        })); //3
    }
}
