package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiveReport {

    public static int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList()); //중복되지 않는 신고 리스트
        HashMap<String, Integer> count = new HashMap<>(); //회원별 신고수

        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList()); //누가 누구를 신고했는지
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count(); //신고를 k번 이상 받았으면 세기
        }).mapToInt(Long::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = solution(id_list, report, k);
        System.out.println(Arrays.toString(result));
    }
}
