package binary;

import java.util.Arrays;

public class BinarySearchTester {
    public static void main(String[] args) {
        int[] a = {15, 27, 39, 77, 92, 108, 121};
        int key = 40;

        int idx = Arrays.binarySearch(a, key); //배열 a에서 값이 key인 요소 검색

        if (idx < 0) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 a[" + idx + "]에 있습니다.");
        }
    }
}
