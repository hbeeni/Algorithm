package logic.정렬;

import java.util.Arrays;

public class 삽입정렬 {

	static int[] a = {42, 32, 24, 60, 15};

	public static void main(String[] args) {
		insertionSort();
		System.out.println(Arrays.toString(a));
	}

	/*
	1. 현재 index에 있는 데이터 값을 선택한다.
	2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색한다.
	3. 삽입 위치부터 index에 있는 위치까지 shift 연산을 수행한다.
	4. 삽입 위치에 현재 선택한 데이터를 삽입하고 index++ 연산을 수행한다.
	5. 전체 데이터의 크기만큼 index가 커질 때까지, 즉 선택할 데이터가 없을 때까지 반복한다.
	 */
	static void insertionSort() {
		for (int i = 1; i < a.length; i++) {
			int insertPoint = 0; //제일 작은 수일 때를 가정하고 초기화
			int insertValue = a[i];

			for (int j = i - 1; j >= 0; j--) { //삽입 포인트 찾기
				if (a[j] < a[i]) {
					insertPoint = j + 1;
					break;
				}
			}

			for (int j = i - 1; j >= insertPoint; j--) { //뒤로 한 칸씩 이동
				a[j + 1] = a[j];
			}

			a[insertPoint] = insertValue;
		}
	}
}
