// 배열의 모든 요소를 역순으로 copy 합니다

package array.problem;

import java.util.Arrays;

public class P5 {

    static void rcopy(int[] a, int[] b) {
        int length = a.length <= b.length ? a.length : b.length;

        for (int i = 0; i < length; i++) {
            a[i] = b[b.length - 1 - i];
        }
    }

    static int[] rcopyV2(int[] b) {
        int[] tmp = new int[b.length];

        for (int i = 0; i < b.length; i++) {
            tmp[i] = b[b.length - 1 - i];
        }

        return tmp;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 7, 9};
        int[] b = {2, 8, 4, 2, 8, 34};

        rcopy(a, b);

        System.out.println("배열 b의 모든 요소를 배열 a에 copy 하였습니다.");
        System.out.println("a" + Arrays.toString(a));
        System.out.println("b" + Arrays.toString(b));

        a = rcopyV2(b);

        System.out.println("배열 b의 모든 요소를 배열 a에 copyV2 하였습니다.");
        System.out.println("a" + Arrays.toString(a));
        System.out.println("b" + Arrays.toString(b));
    }
}
