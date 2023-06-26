package insertion;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int pointer = 0;
            while (a[pointer] < a[i]) {
                pointer++;
            }

            int tmp = a[i];
            System.arraycopy(a, pointer, a, pointer + 1, i - pointer);
            a[pointer] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 7, 1, 9, 8};
        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
