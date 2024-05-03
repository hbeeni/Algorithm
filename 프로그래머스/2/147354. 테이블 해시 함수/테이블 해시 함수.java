import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		Arrays.sort(data, Comparator.comparingInt((int[] a) -> a[col - 1]).thenComparing(a -> a[0] * -1));

		int[] Si = new int[row_end - row_begin + 1];
		int index = 0;

		for (int i = row_begin - 1; i < row_end; i++) {
			for (int j = 0; j < data[0].length; j++) {
				Si[index] += data[i][j] % (i + 1);
			}

			index++;
		}

		int answer = Si[0];
		for (int i = 1; i < Si.length; i++) {
			answer = answer ^ Si[i];
		}

		return answer;
	}
}
