package logic.동적계획법;

import java.util.Scanner;

/* https://www.acmicpc.net/problem/1463
[입력]
2

[출력]
1
---
[입력]
10

[출력]
3
 */
public class 문제_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			int min = arr[i - 1];

			if (i % 3 == 0) {
				min = Math.min(min, arr[i / 3]);
			}

			if (i % 2 == 0) {
				min = Math.min(min, arr[i / 2]);
			}

			arr[i] = min + 1;
		}

		System.out.println(arr[n]);
	}
}
