package logic.자료구조;

//백준 11659 https://www.acmicpc.net/problem/11659
public class 구간합 {

	static int[] a; //기존 배열
	static int[] s; //합 배열

	public static void main(String[] args) {
		a = new int[] {0, 5, 4, 3, 2, 1}; //0번째는 dummy
		calculateSumArray();
		System.out.println(calculatePrefixSum(1, 3)); //12
		System.out.println(calculatePrefixSum(2, 4)); //9
		System.out.println(calculatePrefixSum(5, 5)); //1
	}

	/*
	1. 합 배열 구하기
	- 합 배열을 미리 정의해 놓으면 기존 배열의 일정 범위의 합을 구하는 시간 복잡도가 O(N) -> O(1)로 감소
	- A[0]부터 A[i]까지의 합
	S[i] = A[0] + A[1] + A[2] + ... + A[i-1] + A[i]
		 = S[i-1] + A[i]
	 */
	static void calculateSumArray() {
		s = new int[a.length];
		for (int i = 1; i < a.length; i++) {
			s[i] = s[i - 1] + a[i];
		}
	}

	/*
	2. 구간합 구하기
	i에서 j 까지의 구간합 = S[j] - S[i-1]
	ex) A[2] ~ A[5] 구간합
	S[5] = A[0] + A[1] + A[2] + A[3] + A[4] + A[5]
	S[1] = A[0] + A[1]
	-> S[5] - S[1] = A[2] + A[3] + A[4] + A[5]
	 */
	static int calculatePrefixSum(int start, int end) {
		return s[end] - s[start - 1];
	}
}
