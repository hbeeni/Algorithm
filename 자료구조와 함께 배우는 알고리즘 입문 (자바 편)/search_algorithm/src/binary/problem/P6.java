package binary.problem;

import java.util.Arrays;

public class P6 {
    public static void main(String[] args) {
        int[] a = {15, 27, 39, 77, 92, 108, 121};
        int key = 40;

        int idx = Arrays.binarySearch(a, key); //배열 a에서 값이 key인 요소 검색

        if (idx < 0) {
            int insertPoint = -idx - 1;
            System.out.println("그 값의 요소는 존재하지 않습니다.");
            System.out.printf("삽입 포인트는 %d입니다.\n", insertPoint);
            System.out.printf("x[%d]의 바로 앞에 %d을(를) 삽입하면 배열의 정렬상태가 유지됩니다.", insertPoint, key);
        } else {
            System.out.println("그 값은 a[" + idx + "]에 있습니다.");
        }
    }
}
