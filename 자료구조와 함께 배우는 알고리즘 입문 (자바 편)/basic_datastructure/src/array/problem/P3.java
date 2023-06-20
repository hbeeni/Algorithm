// 배열의 모든 요소의 합계값을 구합니다

package array.problem;

import java.util.Arrays;

public class P3 {

    static int sumOf(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Arrays.toString(a));
        System.out.println("모든 요소의 합계는 " + sumOf(a) + "입니다.");
    }
}
