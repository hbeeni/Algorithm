package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//다익스트라
public class 배달 {

	public static int solution(int n, int[][] road, int k) {
		List<Town>[] list = new ArrayList[n + 1];
		int[] hour = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int[] info : road) {
			int s = info[0];
			int e = info[1];
			int h = info[2];

			list[s].add(new Town(e, h));
			list[e].add(new Town(s, h));
		}

		Arrays.fill(hour, Integer.MAX_VALUE);

		PriorityQueue<Town> pq = new PriorityQueue<>();
		pq.add(new Town(1, 0));
		hour[1] = 0;

		while (!pq.isEmpty()) {
			int now = pq.poll().num;

			if (visited[now]) {
				continue;
			}

			visited[now] = true;

			for (int i = 0; i < list[now].size(); i++) {
				Town next = list[now].get(i);

				if (hour[next.num] > hour[now] + next.hour) {
					hour[next.num] = hour[now] + next.hour;
					pq.add(new Town(next.num, hour[next.num]));
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (hour[i] <= k) {
				answer++;
			}
		}

		return answer;
	}

	static class Town implements Comparable<Town> {

		int num;
		int hour;

		public Town(int num, int hour) {
			this.num = num;
			this.hour = hour;
		}

		@Override
		public int compareTo(Town t) {
			return this.hour - t.hour;
		}
	}

	public static void main(String[] args) {
		int[][] road = {
			{1, 2, 1},
			{2, 3, 3},
			{5, 2, 2},
			{1, 4, 2},
			{5, 3, 1},
			{5, 4, 2},
		};
		System.out.println(solution(5, road, 3));
	}
}
