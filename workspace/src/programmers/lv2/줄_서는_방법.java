package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://gogoma.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A4%84-%EC%84%9C%EB%8A%94-%EB%B0%A9%EB%B2%95-JAVA
public class 줄_서는_방법 {
	public static int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();

		long f = 1;
		for (int i = 1; i <= n; i++) {
			list.add(i);
			f *= i;
		}

		k--;
		int index = 0;

		while (index < n) {
			f /= n - index; //단위 구하기, n - index = 남은 숫자
			answer[index++] = list.remove((int)(k / f));
			k %= f;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 5))); //[3,1,2]
		System.out.println(Arrays.toString(solution(4, 15))); //[3,2,1,4]
	}
}
