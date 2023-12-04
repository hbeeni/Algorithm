import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		int count = 0;
		int maxCount = queue1.length * 4;

		long sum1 = Arrays.stream(queue1).sum();
		long sum2 = Arrays.stream(queue2).sum();

		if ((sum1 + sum2) % 2 == 1) {
			return -1;
		}

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		Arrays.stream(queue1).forEach(q1::add);
		Arrays.stream(queue2).forEach(q2::add);

		while (count < maxCount) {
			if (sum1 == sum2) {
				return count;
			}

			if (sum1 > sum2) {
				int n = q1.poll();
				q2.add(n);
				sum1 -= n;
				sum2 += n;
			} else {
				int n = q2.poll();
				q1.add(n);
				sum2 -= n;
				sum1 += n;
			}
			count++;
		}

		return count == maxCount ? -1 : count;
	}
}
