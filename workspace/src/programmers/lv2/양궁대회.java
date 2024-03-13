package programmers.lv2;

import java.util.Arrays;

//https://record-developer.tistory.com/124
//백트래킹
public class 양궁대회 {

	private static int[] lion = new int[11]; //점수차가 최대일 때 라이언이 쏜 화살 배열
	private static int[] answer = {-1};
	private static int max = 0;

	static int[] solution(int n, int[] info) {
		back(0, n, info);
		return answer;
	}

	static void back(int depth, int n, int[] info) {
		//종료조건: 화살을 다 꽂았을 때
		if (depth == n) {
			int diff = score(info); //점수차 구하기
			if (max <= diff) {
				max = diff;
				answer = lion.clone();
			}

			return;
		}

		//res[i] <= info[i] -> i 과녁에 라이언이 화살을 더 많이 맞추면 반복문 종료
		for (int i = 0; i < info.length && lion[i] <= info[i]; i++) {
			lion[i]++;
			back(depth + 1, n, info);
			lion[i]--;
		}
	}

	static int score(int[] info) {
		int scoreOfApeach = 0;
		int scoreOfLion = 0;

		for (int i = 0; i < info.length; i++) {
			if (info[i] == 0 && lion[i] == 0) {
				continue;
			}
			if (info[i] >= lion[i]) {
				scoreOfApeach += 10 - i;
			} else {
				scoreOfLion += 10 - i;
			}
		}

		int diff = scoreOfLion - scoreOfApeach;
		if (diff <= 0) {
			return -1;
		}
		return diff;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}))); //[0,2,2,0,1,0,0,0,0,0,0]
		// System.out.println(Arrays.toString(solution(1, new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}))); //[-1]
		// System.out.println(Arrays.toString(solution(9, new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}))); //[1,1,2,0,1,2,2,0,0,0,0]
		// System.out.println(Arrays.toString(solution(10, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}))); //[1,1,1,1,1,1,1,1,0,0,2]
	}
}
