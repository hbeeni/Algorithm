package selection;

import utils.SortUtils;

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }

            SortUtils.swap(a, min, i);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 8, 4, 6, 7, 1};
        selectionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
