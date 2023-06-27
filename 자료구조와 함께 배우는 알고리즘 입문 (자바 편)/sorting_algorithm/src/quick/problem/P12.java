// 퀵 정렬(요솟수가 많은 그룹을 먼저 푸시)

package quick.problem;

import java.util.Arrays;
import java.util.Stack;

import static utils.SortUtils.swap;

public class P12 {

    static void quickSortV1(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while (a[pl] < x) {
                pl++;
            }
            while (a[pr] > x) {
                pr--;
            }
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if ((pr - left) > (right - pl)) {
            int tmp;
            tmp = left;
            left = pl;
            pl = tmp;

            tmp = right;
            right = pr;
            pr = tmp;
        }

        if (left < pr) {
            quickSortV1(a, left, pr);
        }
        if (pl < right) {
            quickSortV1(a, pl, right);
        }
    }

    static void quickSortV2(int[] a, int left, int right) {
        Stack<Integer> lstack = new Stack<>(); //나눌 범위의 왼쪽 끝(맨 앞) 요소의 인덱스를 저장하는 스택
        Stack<Integer> rstack = new Stack<>(); //나눌 범위의 오른쪽 끝(맨 뒤) 요소의 인덱스를 저장하는 스택

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];

            do {
                while (a[pl] < x) {
                    pl++;
                }
                while (a[pr] > x) {
                    pr--;
                }
                if (pl <= pr) {
                    swap(a, pl++, pr--);
                }
            } while (pl <= pr);

            if ((pr - left) > (right - pl)) {
                int tmp;
                tmp = left;
                left = pl;
                pl = tmp;

                tmp = right;
                right = pr;
                pr = tmp;
            }

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 4, 2, 6, 1, 3, 9, 7};
        quickSortV1(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        a = new int[]{5, 8, 4, 2, 6, 1, 3, 9, 7};
        quickSortV2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
