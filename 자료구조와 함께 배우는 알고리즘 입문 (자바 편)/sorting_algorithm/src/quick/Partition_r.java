package quick;

import utils.SortUtils;

public class Partition_r {

    //배열을 나눔
    static void partition(int[] a, int n) {
        int left = 0; //왼쪽 커서
        int right = n - 1; //오른쪽 커서
        int pivot = a[n / 2]; //피벗(가운데)

        while (left <= right) {
            while (a[left] < pivot) { //pivot 기준 크거나 같을 때 멈춤
                left++;
            }
            while (a[right] > pivot) { //pivot 기준 작거나 같을 때 멈춤
                right--;
            }

            if (left <= right) {
                SortUtils.swap(a, left++, right--);
            }
        }

        System.out.println("pivot = " + pivot);
        System.out.println("피벗 이하 그룹");
        for (int i = 0; i <= left - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("피벗 일치 그룹");
        for (int i = right + 1; i <= left - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("피벗 이상 그룹");
        for (int i = right + 1; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 7, 4, 5, 2, 6, 3, 9, 2, 2};
        partition(a, a.length);
    }
}
