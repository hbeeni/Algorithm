package insertion;

import java.util.Arrays;

public class InsertionSort_s {

    //뒤에서부터 교환하면서 앞으로 감
    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = a[i];

            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }

            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 7, 1, 9, 8};
        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
