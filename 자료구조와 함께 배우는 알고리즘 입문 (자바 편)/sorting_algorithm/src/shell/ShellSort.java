//시뮬레이션 https://www.w3resource.com/ODSA/AV/Sorting/shellsortAV.html

package shell;

import utils.SortUtils;

import java.util.Arrays;

public class ShellSort {

    private static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                boolean flag = false;

                if (a[i - h] > a[i]) {
                    flag = true;
                    SortUtils.swap(a, i - h, i);
                }

                int j = i - 2 * h;
                if (flag && j >= 0) {
                    if (a[j] > a[i - h]) {
                        SortUtils.swap(a, j, i - h);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 1, 4, 2, 7, 6, 3, 5};
        shellSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
