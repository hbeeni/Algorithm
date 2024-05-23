package logic.동적계획법;

import java.util.Scanner;

/**
 * Bottom-up (상향식)
 * - 반복문
 * - Top-down 방식보다 안전
 */
public class 피보나치_BottomUp {

	private static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		a = new int[n + 1];
		a[1] = 1;

		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 2] + a[i - 1];
		}

		System.out.println(a[n]);
	}
}
