package programmers.lv2;

//https://hu-coding.tistory.com/136
public class 가장_큰_정사각형_찾기 {
	public int solution(int[][] board) {
		int answer = 0;

		//board의 행 또는 열이 1일 때 예외처리
		if (board.length < 2 || board[0].length < 2) {
			return 1;
		}

		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					continue;
				}

				//왼쪽(i,j-1) 왼쪽대각선위(i-1,j-1) 위쪽(i-1,j)
				board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j])) + 1;

				answer = Math.max(answer, board[i][j]);
			}
		}

		return answer * answer;
	}
}
