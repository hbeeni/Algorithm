import java.util.Arrays;

class Solution {
	public int[] solution(String[][] places) {
		int[] result = new int[5];

		int index = 0;
		for (String[] place : places) {
			String[][] room = initRoom(place);

			int answer = 1;

			Loop:
			for (int i = 1; i <= 5; i++) {
				for (int j = 1; j <= 5; j++) {
					if (room[i][j].equals("P")) {
						if (room[i + 1][j].equals("P") || room[i][j + 1].equals("P")) { //오른쪽, 아래
							answer = 0;
							break Loop;
						}

						if (room[i + 2][j].equals("P") && room[i + 1][j].equals("O") ||
							room[i][j + 2].equals("P") && room[i][j + 1].equals("O")) { //오른쪽 +2, 아래 +2
							answer = 0;
							break Loop;
						}

						if (room[i + 1][j + 1].equals("P")) {
							if (!(room[i + 1][j].equals("X") && room[i][j + 1].equals("X"))) { //오른쪽아래대각선
								answer = 0;
								break Loop;
							}
						}

						if (room[i + 1][j - 1].equals("P")) {
							if (!(room[i + 1][j].equals("X") && room[i][j - 1].equals("X"))) { //왼쪽아래대각선
								answer = 0;
								break Loop;
							}
						}
					}
				}
			}

			result[index++] = answer;
		}

		return result;
	}

	private static String[][] initRoom(String[] place) {
		String[][] room = new String[8][8];

		for (String[] arr : room) {
			Arrays.fill(arr, "X");
		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				room[i][j] = String.valueOf(place[i - 1].charAt(j - 1));
			}
		}

		return room;
	}
}
