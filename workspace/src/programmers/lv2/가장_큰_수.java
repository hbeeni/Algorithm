package programmers.lv2;

import java.util.Arrays;

public class 가장_큰_수 {
    public static String solution(int[] numbers) {
        String[] a = new String[numbers.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = String.valueOf(numbers[i]);
        }

        //앞자리에 큰 숫자가 먼저 와야 가장 큰 수를 만들 수 있음 -> 내림차순
        Arrays.sort(a, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        if (a[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String s : a) {
            answer.append(s);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2})); //6210
        System.out.println(solution(new int[]{3, 30, 34, 5, 9})); //9534330
    }
}
