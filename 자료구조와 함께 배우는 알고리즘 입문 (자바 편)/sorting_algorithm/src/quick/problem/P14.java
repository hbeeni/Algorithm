// P13 수정 - 전달 받는 인수 2개

package quick.problem;

import java.util.Arrays;

import static utils.SortUtils.swap;

public class P14 {

    static void insertionSort(int[] a, int left, int right) {
        System.out.println("insertionSort, n=" + (right - left + 1));

        for (int i = left + 1; i <= right; i++) {
            int j;
            int tmp = a[i];

            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }

            a[j] = tmp;
        }
    }

    static void quickSort(int[] a, int n) {
        System.out.println("quickSort(int[] a, int n), n=" + n);
        quickSort(a, 0, n - 1);
    }

    static void quickSort(int[] a, int left, int right) {
        System.out.println("quickSort, n=" + (right - left + 1));

        if (right - left < 9) {
            insertionSort(a, left, right);
        } else {
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
        int[] a = {5, 8, 4, 2, 6, 1, 3, 9, 7, 3, 4, 7, 32, 56, 7, 3};
        quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
