//https://train-validation-test.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-2-%ED%8A%9C%ED%94%8C-Java-%EC%9E%90%EB%B0%94

package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {
    public static int[] solution(String s) {
        String[] split = s.replaceAll("[{}]", " ").trim().split(" ,");
        int[] answer = new int[split.length];

        Set<Integer> set = new HashSet<>();
        Arrays.sort(split, Comparator.comparingInt(String::length));

        int index = 0;
        for (String a : split) {
            for (String str : a.split(",")) {
                int n = Integer.parseInt(str.trim());
                if (set.add(n)) {
                    answer[index++] = n;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"	)));
        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(solution("{{123}}")));
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
