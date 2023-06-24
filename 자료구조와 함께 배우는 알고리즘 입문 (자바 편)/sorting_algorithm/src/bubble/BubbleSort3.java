// 버블 정렬(버전 3: 교환 횟수에 따른 멈춤) - 내가 작성한 거라 확실 x

package bubble;

import java.util.Arrays;

public class BubbleSort3 {

    static int swapCount = 0;
    static int comparisonCount = 0;

    static void swap(int[] a, int idx1, int idx2) {
        swapCount++;
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static void bubbleSort(int[] a, int n) {
        int k = 0;

        for (int i = n - 1; i > 0; i--) {
            boolean swap = false;

            for (int j = k; j < i; j++) {
                comparisonCount++;

                if (a[j] > a[j + 1]) {
                    swap = true;
                    swap(a, j, j + 1);
                } else {
                    k = j;
                }
            }

            if (!swap) {
                break;
            }


        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 9, 4, 7, 8, 6};
        int n = a.length;

        bubbleSort(a, n);
        System.out.println(Arrays.toString(a));
        System.out.println("비교횟수 = " + comparisonCount);
        System.out.println("교환횟수 = " + swapCount);
    }
}
