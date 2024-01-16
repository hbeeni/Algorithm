package logic.탐색;

import java.util.Arrays;

public class 이진탐색 {

	static int[] a = {4, 1, 5, 2, 3};
	static int[] targets = {1, 3, 7, 9, 5};

	public static void main(String[] args) {
		Arrays.sort(a); //이진 탐색을 위해 정렬
		for (int i : targets) {
			binarySearch(i);
		}
	}

	/*
	1. 현재 데이터 셋의 중앙값 선택
	2. 중앙값 > 타겟 데이터 -> 중앙값 기준 왼쪽 데이터셋 선택
	3. 중앙값 < 타겟 데이터 -> 중앙값 기준 오른쪽 데이터셋 선택
	4. 1~3을 반복하다가 중앙값 == 타겟 데이터일 때 탐색 종료
	 */
	static void binarySearch(int n) {
		boolean find = false;

		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			int midIndex = (start + end) / 2;
			int midValue = a[midIndex];

			if (midValue > n) {
				end = midIndex - 1;
			} else if (midValue < n) {
				start = midIndex + 1;
			} else {
				find = true;
				break;
			}
		}

		if (find) {
			System.out.println("found");
		} else {
			System.out.println("not found");
		}
	}
}
