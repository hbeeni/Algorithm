package logic.정렬;

import java.util.Arrays;

//백준 2750 https://www.acmicpc.net/problem/2750
public class 버블정렬 {

	static int[] a = {5, 2, 3, 4, 1};

	public static void main(String[] args) {
		bubbleSort();
		System.out.println(Arrays.toString(a));
	}

	static void bubbleSort() {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
