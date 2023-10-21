package algorithmcodingtest.sorting.quick;

import java.util.Arrays;

public class quickSortEx {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) { //원소가 1개인 경우 종료
            return;
        }

        int pivot = start; //피벗 = 첫 번째 원소
        int left = start + 1;
        int right = end;

        while (left <= right) {
            //피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            //피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) {
                right--;
            }

            if (left > right) { //엇갈렸다면 작은 데이터와 피벗을 교체
                swap(arr, pivot, right);
            } else { //엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
                swap(arr, left, right);
            }
        }

        System.out.println(Arrays.toString(arr));

        //분할 이후 왼쪽, 오른쪽 부분 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}
