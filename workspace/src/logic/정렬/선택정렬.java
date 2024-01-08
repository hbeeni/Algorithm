package logic.정렬;

import java.util.Arrays;

public class 선택정렬 {

	static int[] a = {42, 32, 24, 60, 15};

	public static void main(String[] args) {
		selectionSort();
		System.out.println(Arrays.toString(a));
	}

	/*
	1. 남은 정렬 부분에서 최솟값 또는 최댓값을 찾는다.
	2. 남은 정렬 부분에서 가장 앞에 있는 데이터와 선택된 데이터를 swap한다.
	3. 가장 앞에 있는 데이터의 위치를 변경해(index++) 남은 정렬 부분의 범위를 축소한다.
	4. 전체 데이터 크기만큼 index가 커질 때까지, 즉 남은 정렬 부분이 없을 때까지 반복한다.
	 */
	static void selectionSort() {
		for (int i = 0; i < a.length; i++) {
			int min = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}

			if (a[i] > a[min]) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}
}
