// 배열 요소에 값을 입력받아 역순으로 정렬합니다(과정을 출력)

package array.problem;

import java.util.Arrays;

public class P2 {

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    //배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int idx2 = a.length - i - 1;

            System.out.printf("a[%d] <-> a[%d]\n", i, idx2);
            swap(a, i, idx2);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 9, 6, 7};

        System.out.println(Arrays.toString(nums));
        reverse(nums); //역순으로 정렬
        System.out.println("역순 정렬을 마쳤습니다.");
    }
}
