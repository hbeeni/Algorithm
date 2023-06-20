package array;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

    static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    //배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 9, 6, 7};

        System.out.println("nums = " + Arrays.toString(nums));
        reverse(nums); //역순으로 정렬
        System.out.println("요소를 역순으로 정렬했습니다.");
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
