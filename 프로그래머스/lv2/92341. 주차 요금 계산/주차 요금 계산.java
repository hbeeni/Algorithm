import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        //fees: 기본시간, 기본요금, 단위시간, 단위요금
        //record: 시각 차량번호 내역
        TreeMap<String, List<String>> map = new TreeMap<>();
        for (String record : records) {
            String time = record.substring(0, 5);
            String number = record.substring(6, 10);

            if (map.containsKey(number)) {
                map.get(number).add(time);
            } else {
                List<String> list = new ArrayList<>();
                list.add(time);
                map.put(number, list);
            }
        }

        int[] answer = new int[map.size()];
        Iterator<String> iterator = map.keySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            List<String> times = map.get(iterator.next());
            int totalMin = 0;

            for (int j = 0; j < times.size(); j += 2) {
                String in = times.get(j);
                String out;
                if (j + 1 == times.size()) {
                    out = "23:59";
                } else {
                    out = times.get(j + 1);
                }

                totalMin += (Integer.parseInt(out.substring(0, 2)) - Integer.parseInt(in.substring(0, 2))) * 60;
                totalMin += Integer.parseInt(out.substring(3)) - Integer.parseInt(in.substring(3));
            }

            System.out.println("totalMin = " + totalMin);

            if (totalMin < fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = (int) (fees[1] + Math.ceil((totalMin - fees[0]) / (double) fees[2]) * fees[3]);
            }
        }

        return answer;
    }
}