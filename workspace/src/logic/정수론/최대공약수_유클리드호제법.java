package logic.정수론;

/*
1. 큰 수를 작은 수로 나누는 MOD 연산을 수행한다.
2. 앞 단계에서의 작은 수와 MOD 연산 결괏값(나머지)으로 MOD 연산을 수행한다.
3. 나머지가 0이 되는 순간의 작은 수를 최대 공약수로 선택한다.
 */
public class 최대공약수_유클리드호제법 {
	public static void main(String[] args) {
		System.out.println(gcd(4, 8));
		System.out.println(gcd(16, 20));
		System.out.println(gcd(3, 20));
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
