//병합 정렬 (참고 https://st-lab.tistory.com/233)

package merge;

import java.util.Arrays;

public class MergeSort {

    static int[] buff; //작업용 배열

    private static void mergeSort(int[] a, int n) {
        buff = new int[n];
        mergeSort(a, 0, n - 1);
        buff = null; //작업용 배열 해제
    }

    static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            int i;
            int p = 0; //buff 포인터
            int j = 0; //buff에서 a에 복사한 요소 포인터
            int k = left;

            mergeSort(a, left, center); //배열 앞부분 병합 정렬
            mergeSort(a, center + 1, right); //배열 뒷부분 병합 정렬

            //배열 a의 앞부분을 배열 buff에 복사
            for (i = left; i <= center; i++) {
                buff[p++] = a[i];
            }

            //배열 a의 뒷부분과 배열 buff를 배열 a에 병합
            while (i <= right && j < p) {
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }

            //배열 buff에 남아 있는 요소를 a에 복사
            while (j < p) {
                a[k++] = buff[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 4, 3, 7, 1, 9, 8};
        mergeSort(a, a.length);
        System.out.println("a " + Arrays.toString(a));
    }
}
