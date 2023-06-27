//퀵 정렬(비재귀 버전 : 스택에 푸시 팝하는 과정을 출력)

package quick.problem;

import java.util.Arrays;
import java.util.Stack;

import static utils.SortUtils.swap;

public class P11 {

    static void quickSortV3(int[] a, int left, int right) {
        Stack<Integer> lstack = new Stack<>(); //나눌 범위의 왼쪽 끝(맨 앞) 요소의 인덱스를 저장하는 스택
        Stack<Integer> rstack = new Stack<>(); //나눌 범위의 오른쪽 끝(맨 뒤) 요소의 인덱스를 저장하는 스택

        lstack.push(left);
        rstack.push(right);

        System.out.printf("a[%d]~a[%d]을 나누는 문제를 스택에 푸시합니다.\n", left, right);
        printStack(lstack, rstack);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];
            System.out.printf("스택에서 나누는 문제를 꺼냈습니다. a[%d]~a[%d]을 나눕니다.\n", left, right);

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

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
                System.out.printf("a[%d]~a[%d]을 나누는 문제를 스택에 푸시합니다.\n", left, pr);
                printStack(lstack, rstack);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
                System.out.printf("a[%d]~a[%d]을 나누는 문제를 스택에 푸시합니다.\n", pl, right);
                printStack(lstack, rstack);
            }
        }
    }

    private static void printStack(Stack<Integer> lstack, Stack<Integer> rstack) {
        System.out.print("Lstack:");
        lstack.forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.print("Rstack:");
        rstack.forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 4, 2, 6, 1, 3, 9, 7};
        quickSortV3(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
