//https://seongho96.tistory.com/59

package programmers.lv2;

import java.util.Arrays;

public class n2_배열_자르기 {
    public static int[] solution(int n, long left, long right) {
        int len = (int) (right - left);
        int[] answer = new int[len + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx++] = (int) Math.max(row, col) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, 7, 14))); //[4, 3, 3, 3, 4, 4, 4, 4]
        System.out.println(Arrays.toString(solution(3, 2, 5))); //[3, 2, 2, 3]
    }
}
