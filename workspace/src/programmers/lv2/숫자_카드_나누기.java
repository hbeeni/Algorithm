package programmers.lv2;

//https://coding-grandpa.tistory.com/114
public class 숫자_카드_나누기 {
	private static int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		//각 배열의 최대공약수 구하기
		for (int i = 1; i < arrayA.length; i++) {
			gcdA = gcd(gcdA, arrayA[i]);
			gcdB = gcd(gcdB, arrayB[i]);
		}

		//서로의 배열을 나눌 수 없는지 확인
		if (notDivisible(arrayB, gcdA)) {
			answer = Math.max(answer, gcdA);
		}

		if (notDivisible(arrayA, gcdB)) {
			answer = Math.max(answer, gcdB);
		}

		return answer;
	}

	private static boolean notDivisible(int[] arr, int n) {
		for (int i : arr) {
			if (i % n == 0) {
				return false;
			}
		}

		return true;
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {10, 17}, new int[] {5, 20}));
		System.out.println(solution(new int[] {10, 20}, new int[] {5, 17}));
		System.out.println(solution(new int[] {14, 35, 119}, new int[] {18, 30, 102}));
	}
}
