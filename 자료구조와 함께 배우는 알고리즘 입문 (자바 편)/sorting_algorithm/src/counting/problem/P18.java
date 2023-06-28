//도수 정렬(배열 요솟값은 min 이상 max 이하)

package counting.problem;

import java.util.Arrays;

public class P18 {

    //요소의 범위: min 이상 max 이하
    static void countingSort(int[] a, int n, int min, int max) {
        int[] counting = new int[max - min + 1];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            counting[a[i] - min]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int value = a[i];
            counting[value - min]--;
            result[counting[value - min]] = value;
        }

        System.arraycopy(result, 0, a, 0, n);
    }

    public static void main(String[] args) {
        int n = 30; //수열의 원소 30개
        int min = 20;
        int max = 40;

        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (max - min + 1)) + min;
        }

        System.out.println(Arrays.toString(a));
        countingSort(a, n, min, max);
        System.out.println(Arrays.toString(a));
    }
}
