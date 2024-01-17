package logic.그리디;

import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/1715
public class 그리디 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(10);
		pq.add(20);
		pq.add(40);

		int result = greedy(pq);
		System.out.println(result);
	}

	private static int greedy(PriorityQueue<Integer> pq) {
		int data1;
		int data2;
		int sum = 0;

		while (pq.size() != 1) {
			data1 = pq.remove();
			data2 = pq.remove();
			sum += data1 + data2;
			pq.add(data1 + data2);
		}

		return sum;
	}
}
