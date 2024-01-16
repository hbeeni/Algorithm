package logic.정렬;

import java.util.Arrays;

//https://www.acmicpc.net/problem/10989 : n의 최대 범위가 10,000,000 -> O(nlogn)보다 빠른 알고리즘 필요
public class 기수정렬 {

	static int[] a = {215, 15, 344, 372, 294, 100, 8, 145, 24, 198, 831};

	public static void main(String[] args) {
		radixSort(5);
		System.out.println(Arrays.toString(a));
	}

	/*
	10개의 우선순위 큐 이용 or 배열 이용: 우선순위 큐는 간단하지만 시간 복잡도를 느리게 하는 요소 있음
	1. 일의 자릿수를 기준으로 데이터 저장
	   - 일의 자리에서 정렬된 순서 기준으로 십의 자리에 저장하는 것이 중요
	2. 십의 자릿수를 기준으로 데이터 저장
	...
	 */
	static void radixSort(int maxSize) { //maxSize 최대 자릿수
		int[] output = new int[a.length];
		int jarisu = 1;
		int count = 0;

		while (count != maxSize) { //최대 자릿수만큼 반복
			int[] bucket = new int[10];
			for (int i = 0; i < a.length; i++) { //일의 자리부터 시작
				bucket[(a[i] / jarisu) % 10]++;
			}

			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1]; //합 배열을 이용해 index 계산
			}

			for (int i = a.length - 1; i >= 0; i--) { //현재 자릿수를 기준으로 정렬
				output[bucket[(a[i] / jarisu % 10)] - 1] = a[i];
				bucket[(a[i] / jarisu) % 10]--;
			}

			for (int i = 0; i < a.length; i++) { //다음 자릿수로 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
				a[i] = output[i];
			}

			jarisu *= 10;
			count++;
		}
	}
}
