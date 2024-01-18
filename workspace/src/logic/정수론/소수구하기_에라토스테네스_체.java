package logic.정수론;

import java.util.Arrays;

public class 소수구하기_에라토스테네스_체 {
	public static void main(String[] args) {
		int n = 30;

		//소수가 true
		//1. 주어진 범위까지 배열을 생성한다.
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);

		//2. 1은 소수가 아님을 체크하고, 2부터 시작한다.
		prime[0] = prime[1] = false;

		//선택한 수의 배수를 모두 삭제한다.
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			for (int j = i * i; j <= n; j += i) {
				prime[j] = false;
			}
		}

		//3. 소수를 모두 출력한다.
		for (int i = 0; i < prime.length; i++) {
			if (prime[i]) {
				System.out.print(i + " ");
			}
		}
	}
}
