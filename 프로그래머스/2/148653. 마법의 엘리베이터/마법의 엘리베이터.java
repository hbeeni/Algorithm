class Solution {
	public int solution(int storey) {
		int answer = 0;

		while (storey != 0) {
			int remainder = storey % 10;
			storey /= 10;

			if (remainder == 5) {
				answer += remainder;

				if (storey % 10 >= 5) {
					storey++;
				}
			} else if (remainder < 5) {
				answer += remainder;
			} else {
				answer += 10 - remainder;
				storey++;
			}
		}

		return answer;
	}
}
