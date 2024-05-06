import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int solution(int[] arrayA, int[] arrayB) {
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		int answer = find(arrayA, arrayB);
		answer = Math.max(answer, find(arrayB, arrayA));

		return answer;
	}

	private int find(int[] a, int[] b) {
		List<Integer> list = new ArrayList<>();

		for (int i = a[0]; i >= 2; i--) {
			boolean flag = true;

			for (int n : a) {
				if (n % i != 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				list.add(i);
			}
		}

		for (Integer i : list) {
			boolean flag = true;

			for (int n : b) {
				if (n % i == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				return i;
			}
		}

		return 0;
	}
}
