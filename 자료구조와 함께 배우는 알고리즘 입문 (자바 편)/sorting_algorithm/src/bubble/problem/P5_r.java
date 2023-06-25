package bubble.problem;

import java.util.Arrays;

public class P5_r {

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static void shakerSort(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        int start = right; //교환 시작 인덱스

        while (left < right) {
            //제일 작은 수를 맨 앞으로
            for (int i = right; i > left; i--) {
                if (a[i - 1] > a[i]) {
                    swap(a, i, i - 1);
                    start = i;
                }
            }
            left = start;

            //제일 큰 수를 맨 뒤로
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    start = i;
                }
            }
            right = start;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 9, 4, 7, 8, 6};
        int n = a.length;

        shakerSort(a, n);
        System.out.println(Arrays.toString(a));
    }
}
