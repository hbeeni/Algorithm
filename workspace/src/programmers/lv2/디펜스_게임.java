package programmers.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://rovictory.tistory.com/195
public class 디펜스_게임 {
	public static int solution(int n, int k, int[] enemy) {
		int answer = 0;
		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i : enemy) {
			n -= i;
			q.add(i);

			if (n < 0) {
				if (k > 0) {
					n += q.poll();
					k--;
				} else {
					break;
				}
			}

			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1})); //5
		System.out.println(solution(2, 4, new int[] {3, 3, 3, 3})); //4
	}
}
