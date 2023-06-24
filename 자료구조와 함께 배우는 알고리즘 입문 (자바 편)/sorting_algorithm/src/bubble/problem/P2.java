package bubble.problem;

import java.util.Arrays;

public class P2 {

    static int swapCount = 0;
    static int comparisonCount = 0;

    static void swap(int[] a, int idx1, int idx2) {
        swapCount++;
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                comparisonCount++;
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
        System.out.println("비교횟수 = " + comparisonCount);
        System.out.println("교환횟수 = " + swapCount);
    }
}
