/**
 * https://st-lab.tistory.com/104
 * 수의 개수는 적지만, 범위가 매우 크면 심한 메모리 낭비
 * Java: 1차원 배열 객체 하나의 크기는 최대 Integer.MAX_VALUE 미만으로만 가능
 * -> 대부분 TimSort or QuickSort 사용
 */

package counting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] a = new int[100]; //수열의 원소 100개
        int[] counting = new int[31]; //수의 범위: 0 ~ 30
        int[] result = new int[100]; //정렬될 배열

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 31);
        }

        //Counting Sort
        //과정 1: a의 요소 값을 index로 하는 counting 배열 값 1 증가
        for (int num : a) {
            counting[num]++;
        }

        //과정 2: counting 배열 누적합
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        //과정 3: 뒤에서부터 순회
        for (int i = a.length - 1; i >= 0; i--) {
            int value = a[i];
            //i번째 원소를 인덱스로 하는 counting 배열 1 감소
            counting[value]--;
            //counting 배열의 값을 인덱스로 해서 result에 value 저장
            result[counting[value]] = value;
        }

        System.out.print("초기 배열: ");
        System.out.println(Arrays.toString(a));

        System.out.print("counting 배열: ");
        System.out.println(Arrays.toString(counting));

        System.out.print("정렬된 배열: ");
        System.out.println(Arrays.toString(result));
    }
}
