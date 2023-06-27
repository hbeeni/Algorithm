/**
 * 개선 버전
 * 1. 처음, 가운데, 끝 요소 정렬
 * 2. 가운데 요소를 피벗으로 지정
 * 3. 가운데 요소와 끝에서 두 번째 요소를 교환
 */

package quick;

import java.util.Arrays;

import static utils.SortUtils.swap;

public class QuickSort3 {

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int m = sort3elem(a, pl, (pl + pr) / 2, pr); //처음, 가운데, 끝 요소 정렬
        int x = a[m]; //피벗

        swap(a, m, right - 1); //가운데 요소와 끝에서 두번째 요소 교환
        pl++;
        pr -= 2;

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

    //a[a], a[b], a[c]를 정렬 (가운데 값의 인덱스 반환)
    private static int sort3elem(int[] arr, int a, int b, int c) {
        if (arr[a] > arr[b]) {
            swap(arr, a, b);
        }
        if (arr[b] > arr[c]) {
            swap(arr, b, c);
        }
        if (arr[a] > arr[b]) {
            swap(arr, a, b);
        }

        return b;
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 4, 2, 6, 1, 3, 9, 7};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
