//https://hstory0208.tistory.com/entry/Java%EC%9E%90%EB%B0%94-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv2-%EC%97%B0%EC%86%8D-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4-%ED%95%A9%EC%9D%98-%EA%B0%9C%EC%88%98-Set

package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int start = 1;
        while (start <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < i + start; j++) {
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
            start++;
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 9, 1, 1, 4})); //18
    }
}
