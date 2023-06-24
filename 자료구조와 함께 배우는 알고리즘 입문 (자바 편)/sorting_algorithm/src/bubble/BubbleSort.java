// 버블 정렬(단순 교환 정렬, 각 패스를 뒤쪽 -> 앞쪽 순서로 수행) (버전 1)

package bubble;

import java.util.Arrays;

public class BubbleSort {

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
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
