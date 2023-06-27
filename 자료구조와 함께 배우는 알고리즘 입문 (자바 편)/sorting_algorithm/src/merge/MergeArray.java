//정렬을 마친 두 배열의 병합

package merge;

import java.util.Arrays;

public class MergeArray {

    //정렬을 마친 배열 a, b를 병합해 배열 c에 저장, n: 요소수
    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        int pa = 0; //a배열 포인터
        int pb = 0; //b배열 포인터
        int pc = 0; //c배열 포인터

        //작은 쪽 값을 c에 저장
        while (pa < na && pb < nb) {
            c[pc++] = (a[pa] < b[pb]) ? a[pa++] : b[pb++];
        }

        //남아 있는 요소를 복사
        while (pa < na) {
            c[pc++] = a[pa++];
        }
        while (pb < nb) {
            c[pc++] = b[pb++];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 11, 13};
        int[] b = {1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[a.length + b.length];
        merge(a, a.length, b, b.length, c);
        System.out.println("a " + Arrays.toString(a));
        System.out.println("b " + Arrays.toString(b));
        System.out.println("c " + Arrays.toString(c));
    }
}
