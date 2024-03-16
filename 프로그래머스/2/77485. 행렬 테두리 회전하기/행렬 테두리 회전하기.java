import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	private int[][] matrix;
	
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		matrix = new int[rows + 1][columns + 1];

		int element = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				matrix[i][j] = element++;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int min = Integer.MAX_VALUE;

			int x1 = queries[i][0];
			int y1 = queries[i][1];
			int x2 = queries[i][2];
			int y2 = queries[i][3];

			Queue<Integer> queue = new LinkedList<>();
			queue.add(matrix[x1][y1]);

			for (int y = y1 + 1; y <= y2; y++) {
				min = moveBorderAndGetMin(queue, x1, y, min);
			}

			for (int x = x1 + 1; x <= x2; x++) {
				min = moveBorderAndGetMin(queue, x, y2, min);
			}

			for (int y = y2 - 1; y >= y1; y--) {
				min = moveBorderAndGetMin(queue, x2, y, min);
			}

			for (int x = x2 - 1; x >= x1; x--) {
				min = moveBorderAndGetMin(queue, x, y1, min);
			}

			answer[i] = min;
		}

		return answer;
	}

	private int moveBorderAndGetMin(Queue<Integer> queue, int x, int y, int min) {
		int value = queue.poll();
		queue.add(matrix[x][y]);
		matrix[x][y] = value;
		return Math.min(min, value);
	}
}