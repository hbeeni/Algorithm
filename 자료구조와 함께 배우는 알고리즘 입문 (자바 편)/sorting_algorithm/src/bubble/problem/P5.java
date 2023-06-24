// 양방향 버블 정렬(셰이커 정렬)

package bubble.problem;

import java.util.Arrays;

public class P5 {

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static void shakerSort(int[] a, int n) {
        //정렬 완료
        int left = 0;
        int right = n - 1;
        //마지막 교환 위치
        int last = right;

        while (left < right) {
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            left = last;

            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;
                }
            }
            right = last;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 9, 4, 7, 8, 6};
        int n = a.length;

        shakerSort(a, n);
        System.out.println(Arrays.toString(a));
    }
}
