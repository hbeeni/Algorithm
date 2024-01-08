package logic.자료구조;

//백준 2018 https://www.acmicpc.net/problem/2018
public class 투포인터 {
	public static void main(String[] args) {
		System.out.println(twoPointer(15)); //4
	}

	static int twoPointer(int n) {
		int count = 1; //숫자 n만 뽑는 경우의 수 미리 넣음
		int sum = 1;

		int start = 1;
		int end = 1;

		while (end < n) {
			if (sum == n) { //현재 연속 합이 n과 같으면
				count++;
				end++;
				sum += end;
			} else if (sum > n) { //현재 연속 합이 n보다 크면
				sum -= start;
				start++;
			} else { //현재 연속 합이 n보다 작으면
				end++;
				sum += end;
			}
		}

		return count;
	}
}
