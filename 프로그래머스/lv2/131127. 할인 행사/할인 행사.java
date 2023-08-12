import java.util.HashMap;
import java.util.Map;

class Solution {
    static int count; //number 원소 중 0 개수 -> want 길이랑 같으면 회원가입 가능
    static int answer;

    public int solution(String[] want, int[] number, String[] discount) {
        //map에 want, want 인덱스 넣기
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }

        /*
        for (0 ~ 10)
            discount[i]의 값이 map에 있으면
                number[index]--
        checkNumberArray()
         */
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                number[map.get(discount[i])]--;
            }
        }
        checkNumberArray(number, want.length);

        /*
        int start = 1, end = 10
        while (end < discount 길이)
            discount[start - 1의 인덱스]가 map에 있으면
                number[index]++
            discount[end]의 값이 map에 있으면
                number[index]--
            checkNumberArray()
         */
        int start = 1;
        int end = 10;

        while (end < discount.length) {
            if (map.containsKey(discount[start - 1])) {
                number[map.get(discount[start - 1])]++;
            }
            if (map.containsKey(discount[end])) {
                number[map.get(discount[end])]--;
            }

            checkNumberArray(number, want.length);
            start++;
            end++;
        }

        return answer;
    }

    private static void checkNumberArray(int[] number, int length) {
        /*
        for (0 ~ number 길이)
            number[i] = 0이면
                count++
        count 길이 = want 길이면
            answer++
        count = 0으로 초기화
         */
        for (int i = 0; i < number.length; i++) {
            if (number[i] == 0) {
                count++;
            }
        }

        if (count == length) {
            answer++;
        }

        count = 0;
    }
}