class Solution {
	public int solution(String s) {
		int answer = s.length();

		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder compressedString = new StringBuilder();
			String croppedString = s.substring(0, i);
			int count = 1;

			for (int j = i; j < s.length(); j += i) {
				int end = j + i;
				if (end > s.length()) {
					end = s.length();
				}

				String str = s.substring(j, end);
				if (str.equals(croppedString)) {
					count++;
				} else {
					if (count == 1) {
						compressedString.append(croppedString);
					} else {
						compressedString.append(count).append(croppedString);
					}

					count = 1;
					croppedString = str;
				}
			}

			if (count == 1) {
				compressedString.append(croppedString);
			} else {
				compressedString.append(count).append(croppedString);
			}

			answer = Math.min(compressedString.toString().length(), answer);
		}

		return answer;
	}
}
