package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보_수집_유효기간 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int day = getDay(today);

        for (String term : terms) {
            String[] tmp = term.split(" ");
            termMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");

            if ((getDay(tmp[0]) + termMap.get(tmp[1]) * 28) > day) {
                continue;
            }

            list.add(i + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    static int getDay(String date) {
        int y = Integer.parseInt(date.split("[.]")[0]);
        int m = Integer.parseInt(date.split("[.]")[1]);
        int d = Integer.parseInt(date.split("[.]")[2]);

        return y * 12 * 28 + m * 28 + d;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] result = solution(today, terms, privacies);
        System.out.println(Arrays.toString(result));
    }
}
