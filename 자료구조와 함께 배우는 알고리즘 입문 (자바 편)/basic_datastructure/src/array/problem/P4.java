// 배열의 모든 요소를 copy 합니다

package array.problem;

import java.util.Arrays;

public class P4 {

    static void copy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;

        for (int i = 0; i < num; i++)
            a[i] = b[i];
    }

    static int[] copyV2(int[] b) {
        return Arrays.copyOf(b, b.length);
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 7, 9};
        int[] b = {2, 8, 4, 2, 8, 34};

        copy(a, b);

        System.out.println("배열 b의 모든 요소를 배열 a에 copy 하였습니다.");
        System.out.println("a" + Arrays.toString(a));
        System.out.println("b" + Arrays.toString(b));

        a = copyV2(b);

        System.out.println("배열 b의 모든 요소를 배열 a에 copyV2 하였습니다.");
        System.out.println("a" + Arrays.toString(a));
        System.out.println("b" + Arrays.toString(b));
    }
}
