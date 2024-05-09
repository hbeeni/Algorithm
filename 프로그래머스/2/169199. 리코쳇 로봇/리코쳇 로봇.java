import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private int[] dx = {-1, 1, 0, 0};
	private int[] dy = {0, 0, -1, 1};

	private int maxX;
	private int maxY;
	private char[][] arr;

	public int solution(String[] board) {
		maxX = board.length - 1;
		maxY = board[0].length() - 1;

		arr = new char[maxX + 1][maxY + 1];
		boolean[][] visited = new boolean[maxX + 1][maxY + 1];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i <= maxX; i++) {
			for (int j = 0; j <= maxY; j++) {
				arr[i][j] = board[i].charAt(j);

				if (arr[i][j] == 'R') {
					queue.add(new int[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int x = point[0];
			int y = point[1];
			int count = point[2];

			if (arr[x][y] == 'G') {
				return count;
			}

			for (int i = 0; i < 4; i++) {
				int cx = x;
				int cy = y;

				while (validated(cx, cy) && arr[cx][cy] != 'D') {
					int nx = cx + dx[i];
					int ny = cy + dy[i];

					if (!visited[cx][cy] && (!validated(nx, ny) || arr[nx][ny] == 'D')) {
						queue.add(new int[] {cx, cy, count + 1});
						visited[cx][cy] = true;
						break;
					}

					cx += dx[i];
					cy += dy[i];
				}
			}
		}

		return -1;
	}

	private boolean validated(int x, int y) {
		return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
	}
}
