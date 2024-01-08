package logic.자료구조;

//백준 2559 https://www.acmicpc.net/problem/2559
public class 슬라이딩윈도우 {

	static int[] a = {3, -2, -4, -9, 0, 3, 7, 13, 8, -3};

	public static void main(String[] args) {
		System.out.println(slidingWindow(2)); //21
		System.out.println(slidingWindow(5)); //31
	}

	//2개의 포인터로 범위를 지정한 다음 범위를 유지한 채로 이동
	//k: 연속적인 날짜의 수
	static int slidingWindow(int k) {
		//초기 설정
		int max = 0;
		for (int i = 0; i < k; i++) {
			max += a[i];
		}

		//슬라이딩윈도우 처리
		int sum = max;
		for (int i = k; i < a.length; i++) {
			int j = i - k;
			sum += a[i] - a[j];
			max = Math.max(max, sum);
		}

		return max;
	}
}
