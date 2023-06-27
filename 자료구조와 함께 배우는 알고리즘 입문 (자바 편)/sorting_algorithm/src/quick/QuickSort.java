//참고 사이트 https://st-lab.tistory.com/250

package quick;

import java.util.Arrays;

import static utils.SortUtils.swap;

public class QuickSort {

    //재귀
    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while (a[pl] < x) {
                pl++;
            }
            while (a[pr] > x) {
                pr--;
            }
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(a, left, pr);
        }
        if (pl < right) {
            quickSort(a, pl, right);
        }
    }

    //과정 출력
    static void quickSortV2(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        System.out.printf("a[%d]~a[%d]: {", left, right);
        for (int i = left; i < right; i++) {
            System.out.printf("%d, ", a[i]);
        }
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) {
                pl++;
            }
            while (a[pr] > x) {
                pr--;
            }
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSortV2(a, left, pr);
        }
        if (pl < right) {
            quickSortV2(a, pl, right);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 4, 2, 6, 1, 3, 9, 7};
        quickSortV2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
