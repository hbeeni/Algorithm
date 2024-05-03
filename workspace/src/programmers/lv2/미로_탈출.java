package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

//https://chamggae.tistory.com/199
public class 미로_탈출 {
	private static int maxX;
	private static int maxY;

	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};

	public static int solution(String[] maps) {
		maxX = maps.length - 1;
		maxY = maps[0].length() - 1;

		int[] start = new int[3];
		int[] lever = new int[3];

		for (int i = 0; i <= maxX; i++) {
			for (int j = 0; j <= maxY; j++) {
				if (maps[i].charAt(j) == 'S') {
					start = new int[] {i, j, 0};
				}

				if (maps[i].charAt(j) == 'L') {
					lever = new int[] {i, j, 0};
				}
			}
		}

		int result1 = bfs(maps, start, 'L');
		int result2 = bfs(maps, lever, 'E');

		if (result1 == -1 || result2 == -1) {
			return -1;
		}

		return result1 + result2;
	}

	private static int bfs(String[] maps, int[] s, char target) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[maxX + 1][maxY + 1];

		queue.add(s);
		visited[s[0]][s[1]] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int count = now[2];

			if (maps[x].charAt(y) == target) {
				return count;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (validate(nextX, nextY) && !visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
					queue.add(new int[] {nextX, nextY, count + 1});
					visited[nextX][nextY] = true;
				}
			}
		}

		return -1;
	}

	private static boolean validate(int x, int y) {
		return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"})); //16
		System.out.println(solution(new String[] {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"})); //-1
	}
}
