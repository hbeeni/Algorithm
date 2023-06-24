// 단순교환정렬(각 패스를 앞쪽 → 뒤쪽 순서로 수행)

package bubble.problem;

import java.util.Arrays;

public class P1 {

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 4, 3, 7, 1, 9, 8};
        int n = a.length;

        bubbleSort(a, n);
        System.out.println(Arrays.toString(a));
    }
}
