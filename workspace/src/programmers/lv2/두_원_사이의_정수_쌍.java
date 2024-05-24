package programmers.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/181187
//https://taehoung0102.tistory.com/299
public class 두_원_사이의_정수_쌍 {
	private static long solution(int r1, int r2) {
		long answer = 0;

		for (int x = 1; x <= r2; x++) {
			long maxY = (long)Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * x * x));
			long minY = (long)Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * x * x));

			answer += (maxY - minY + 1);
		}

		return answer * 4;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, 3)); //20
	}
}
