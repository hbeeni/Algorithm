package programmers.lv2;

//https://hstory0208.tistory.com/entry/Java%EC%9E%90%EB%B0%94-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv2-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-Greedy%ED%83%90%EC%9A%95%EB%B2%95
public class 조이스틱 {
	public static int solution(String name) {
		int answer = 0;
		int len = name.length();
		int move = len - 1; //default: 오른쪽으로 쭉 가는 경우

		for (int i = 0; i < len; i++) {
			//상하로 움직여서 알파벳 찾기
			char current = name.charAt(i);
			answer += Math.min(current - 'A', 'Z' - current + 1);

			//연속된 'A'가 끝나는 지점 찾기
			int next = i + 1;
			while (next < len && name.charAt(next) == 'A') {
				next++;
			}

			//좌우이동 최소 횟수 구하기
			move = Math.min(move, (i * 2) + len - next); //0 -> 오른쪽 -> 0 -> 왼쪽
			move = Math.min(move, (len - next) * 2 + i); //0 -> 왼쪽 -> 0 -> 오른쪽
		}

		answer += move;

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
		System.out.println(solution("BBBBAAAAAAAB"));
	}
}
