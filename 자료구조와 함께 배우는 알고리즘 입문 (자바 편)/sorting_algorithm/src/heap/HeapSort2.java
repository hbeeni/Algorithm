/**
 * https://st-lab.tistory.com/225
 * 개선된 버전: 비재귀
 * 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 * 2 + 1
 * 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 * 2 + 2
 * 부모 노드 인덱스 = (자식 노드 인덱스 - 1) / 2
 */

package heap;

import java.util.Arrays;

import static utils.SortUtils.swap;

public class HeapSort2 {

    //부모 노드 인덱스를 얻는 함수
    static int getParent(int child) {
        return (child - 1) / 2;
    }

    //힙을 만드는 함수
    static void heapify(int[] a, int parentIdx, int lastIdx) {
        //왼쪽 자식 노드 인덱스가 마지막 인덱스를 넘지 않을 때까지 반복
        while (2 * parentIdx + 1 <= lastIdx) {
            //현재 부모 노드 인덱스를 가장 큰 값이 가지고 있다고 가정
            int leftChildIdx = 2 * parentIdx + 1;
            int rightChildIdx = 2 * parentIdx + 2;
            int largestIdx = parentIdx;

            //왼쪽 자식 노드 비교
            if (a[leftChildIdx] > a[largestIdx]) {
                largestIdx = leftChildIdx;
            }
            //오른쪽 자식 노드 비교
            if (rightChildIdx <= lastIdx && a[rightChildIdx] > a[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            //교환 발생
            if (largestIdx != parentIdx) {
                //두 노드 교환
                swap(a, parentIdx, largestIdx);
                //교환된 자식 노드를 부모노드가 되도록 교체
                parentIdx = largestIdx;
            } else {
                return;
            }
        }
    }

    //힙 정렬
    static void heapSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        //가장 마지막 노드의 부모 노드 인덱스
        int parentIdx = getParent(n - 1);

        //초기 설정: max heap 만들기
        for (int i = parentIdx; i >= 0; i--) {
            //부모노드(i)를 1씩 줄이면서 heap 조건을 만족시키도록 재구성
            heapify(a, i,  n - 1);
        }

        //정렬
        for (int i = n - 1; i > 0; i--) {
            //root(최대값)인 0번 인덱스와 i번 인덱스를 교환
            swap(a, 0, i);
            //0 ~ (i - 1)까지의 부분 트리에 대해 max heap을 만족하도록 재구성
            heapify(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 7, 5, 4, 2, 8};
        heapSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
