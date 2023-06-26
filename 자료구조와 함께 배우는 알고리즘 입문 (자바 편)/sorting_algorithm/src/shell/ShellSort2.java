//Gap Sequences https://st-lab.tistory.com/209

package shell;

import java.util.Arrays;

public class ShellSort2 {

    private static void shellSort(int[] a, int n) {
        int h;
        for (h = 1; h < n; h = 3 * h + 1) {}

        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];

                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }

                a[j + h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 7, 1, 9, 8};
        shellSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
