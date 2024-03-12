package programmers.lv2;

import java.util.Arrays;

//https://taehoung0102.tistory.com/262
//완전탐색
public class 이모티콘_할인행사 {
	static int[] answer = new int[2];

	public static int[] solution(int[][] users, int[] emoticons) {
		int[] percents = new int[emoticons.length]; //할인율: 10, 20, 30, 40

		comb(percents, 0, users, emoticons);

		return answer;
	}

	static void comb(int[] arr, int index, int[][] users, int[] emoticons) {
		if (index == arr.length) {
			cal(arr, users, emoticons);
			return;
		}

		for (int i = 10; i <= 40; i += 10) {
			arr[index] = i;
			comb(arr, index + 1, users, emoticons);
		}
	}

	static void cal(int[] arr, int[][] users, int[] emoticons) {
		int[] totalPrice = new int[users.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < users.length; j++) {
				if (users[j][0] <= arr[i]) {
					totalPrice[j] += emoticons[i] / 100 * (100 - arr[i]);
				}
			}
		}

		int member = 0;
		int total = 0;
		for (int i = 0; i < users.length; i++) {
			if (users[i][1] <= totalPrice[i]) {
				member++;
			} else {
				total += totalPrice[i];
			}
		}

		if (answer[0] < member) {
			answer[0] = member;
			answer[1] = total;
		} else if (answer[0] == member && answer[1] < total) {
			answer[1] = total;
		}
	}

	public static void main(String[] args) {
		int[][] users1 = {
			{40, 10000},
			{25, 10000}
		};

		int[][] users2 = {
			{40, 2900},
			{23, 10000},
			{11, 5200},
			{5, 5900},
			{40, 3100},
			{27, 9200},
			{32, 6900}
		};

		System.out.println(Arrays.toString(solution(users1, new int[] {7000, 9000})));
		System.out.println(Arrays.toString(solution(users2, new int[] {1300, 1500, 1600, 4900})));
	}
}
