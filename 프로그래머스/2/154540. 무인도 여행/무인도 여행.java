import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	
	private boolean[][] visited;
	
	public List<Integer> solution(String[] maps) {
		List<Integer> answer = new ArrayList<>();
		visited = new boolean[maps.length][maps[0].length()];
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
					answer.add(calc(maps, i, j));
				}
			}
		}

		if (answer.isEmpty()) {
			return List.of(-1);
		}

		Collections.sort(answer);
		return answer;
	}

	private int calc(String[] maps, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		int sum = 0;

		queue.add(new int[] {x, y});
		sum += maps[x].charAt(y) - '0';
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (isValidDestination(maps, nextX, nextY) && !visited[nextX][nextY]) {
					sum += maps[nextX].charAt(nextY) - '0';
					queue.add(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return sum;
	}

	private static boolean isValidDestination(String[] maps, int x, int y) {
		return x >= 0 && x < maps.length && y >= 0 && y < maps[0].length() && maps[x].charAt(y) != 'X';
	}
}