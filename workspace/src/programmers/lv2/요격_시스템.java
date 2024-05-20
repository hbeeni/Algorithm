package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

//https://velog.io/@phdljr/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-level2-181188-%EC%9A%94%EA%B2%A9-%EC%8B%9C%EC%8A%A4%ED%85%9CJava
/*
https://ksb-dev.tistory.com/304
스케쥴링 문제와 유사: 끝나는 시간을 기준으로 오름차순 하고, 반복하면서 시작과 종점 비교
 */
public class 요격_시스템 {
	public static int solution(int[][] targets) {
		int answer = 0;

		Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

		int before = 0;

		for (int[] target : targets) {
			if (before <= target[0]) {
				before = target[1];
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{4, 5},
			{4, 8},
			{10, 14},
			{11, 13},
			{5, 12},
			{3, 7},
			{1, 4}
		})); //3
	}
}
