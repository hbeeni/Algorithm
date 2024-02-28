package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://jisunshine.tistory.com/148
//bfs
public class 거리두기_확인하기 {

	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int i = 0; i < places.length; i++) {
			String[] place = places[i];

			int result = 1;
			outer:
			for (int row = 0; row < 5; row++) {
				for (int col = 0; col < 5; col++) {
					if (place[row].charAt(col) == 'P' && !bfs(row, col, place)) {
						result = 0;
						break outer;
					}
				}
			}

			answer[i] = result;
		}

		return answer;
	}

	private static boolean bfs(int row, int col, String[] place) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});

		while (!queue.isEmpty()) {
			int[] position = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = position[0] + dr[i];
				int nc = position[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == row && nc == col)) {
					continue;
				}

				int distance = Math.abs(nr - row) + Math.abs(nc - col);

				if (place[nr].charAt(nc) == 'P' && distance <= 2) {
					return false;
				} else if (place[nr].charAt(nc) == 'O' && distance < 2) {
					queue.offer(new int[] {nr, nc});
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {
			{"POOPO", "OOOOO", "OOOXP", "OPOPX", "OOOOO"}, //0
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, //1
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, //0
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, //1
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, //1
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}  //1
		})));
	}
}
