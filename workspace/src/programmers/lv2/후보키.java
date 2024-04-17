package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {
	private static Set<String> candi = new HashSet<>();

	public static int solution(String[][] relation) {
		for (int i = 0; i < relation[0].length; i++) {
			boolean[] visited = new boolean[relation[0].length];
			comb(relation, visited, 0, 0, i + 1);
		}

		return candi.size();
	}

	public static void comb(String[][] relation, boolean[] visited, int start, int n, int target) {
		if (n == target) {
			List<Integer> keyList = new ArrayList<>();
			String key = "";

			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) { //선택된 칼럼
					key += i;
					keyList.add(i);
				}
			}

			Set<String> set = new HashSet<>();

			//유일성 검증
			for (int i = 0; i < relation.length; i++) {
				String temp = "";

				for (Integer j : keyList) {
					temp += relation[i][j];
				}

				if (set.contains(temp)) {
					return;
				} else {
					set.add(temp);
				}
			}

			//후보키 검증
			for (String s : candi) {
				int count = 0;

				for (int i = 0; i < key.length(); i++) {
					String subS = String.valueOf(key.charAt(i));

					if (s.contains(subS)) {
						count++;
					}
				}

				if (count == s.length()) {
					return;
				}
			}

			//후보키 검증이 완료되면 후보키에 추가
			candi.add(key);
			return;
		}

		for (int i = start; i < visited.length; i++) { //키 선택 조합
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			comb(relation, visited, i, n + 1, target);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		int ans = solution(new String[][] {
			{"100", "ryan", "music", "2"},
			{"200", "apeach", "math", "2"},
			{"300", "tube", "computer", "3"},
			{"400", "con", "computer", "4"},
			{"500", "muzi", "music", "3"},
			{"600", "apeach", "music", "2"}
		});
		System.out.println(ans); //2
	}
}
