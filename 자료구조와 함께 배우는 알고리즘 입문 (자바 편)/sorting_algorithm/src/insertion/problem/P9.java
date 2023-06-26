package insertion.problem;

import java.util.Arrays;

public class P9 {

    //이미 정렬된 부분은 이진 검색 사용
    private static void binaryInsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int l = 0;
            int r = i - 1;
            int pointer = 0;

            while (l <= r) {
                int m = (l + r) / 2;

                if (a[m] == a[i]) {
                    pointer = m;
                    break;
                } else if (a[m] < a[i]) {
                    l = m + 1;
                    pointer = l;
                } else {
                    r = m - 1;
                    pointer = r;
                }
            }

            if (pointer == i) {
                continue;
            }

            if (pointer < 0) {
                pointer = 0;
            } else {
                while (a[pointer] < a[i]) {
                    pointer++;
                }
            }

            int tmp = a[i];
            System.arraycopy(a, pointer, a, pointer + 1, i - pointer);
            a[pointer] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 7, 1, 9, 8};
        binaryInsertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
