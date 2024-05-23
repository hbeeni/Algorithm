package logic.동적계획법;

import java.util.Scanner;

/**
 * Top-down (하향식)
 * - 재귀함수
 * - 재귀의 깊이가 매우 깊어질 경우 런타임 에러가 발생할 수 있음 (실제 코테에서 이 부분까지 고려애햐 아흔 난이도는 잘 안나옴)
 */
public class 피보나치_TopDown {

	private static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		a = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			a[i] = -1;
		}
		a[0] = 0;
		a[1] = 1;

		System.out.println(fibonacci(n));
	}

	static int fibonacci(int n) {
		if (a[n] != -1) { //기존에 계산한 적이 있는 부분의 문제는 재계산하지 않고 리턴
			return a[n];
		}

		return a[n] = fibonacci(n - 2) + fibonacci(n - 1); //memoization: 구한 값을 바로 리턴하지 않고, DP 테이블에 저장한 후 리턴
	}
}
