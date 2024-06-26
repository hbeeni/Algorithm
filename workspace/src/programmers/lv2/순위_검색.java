package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://jisunshine.tistory.com/153
public class 순위_검색 {

	private static Map<String, List<Integer>> map = new HashMap<>();

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (int i = 0; i < info.length; i++) {
			makeSentence(info[i].split(" "), "", 0);
		}

		//각 경우의 수에 대한 점수 정렬
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] q = query[i].split(" ");
			answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
		}

		return answer;
	}

	private static int binarySearch(String key, int score) {
		List<Integer> list = map.get(key);

		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (list.get(mid) < score) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return list.size() - start;
	}

	//모든 경우의 수 문장 만들기
	private static void makeSentence(String[] a, String str, int count) {
		if (count == 4) {
			if (!map.containsKey(str)) {
				List<Integer> list = new ArrayList<>();
				map.put(str, list);
			}
			map.get(str).add(Integer.parseInt(a[4]));
			return;
		}

		makeSentence(a, str + "-", count + 1);
		makeSentence(a, str + a[count], count + 1);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {
			"java backend junior pizza 150",
			"python frontend senior chicken 210",
			"python frontend senior chicken 150",
			"cpp backend senior pizza 260",
			"java backend junior chicken 80",
			"python backend senior chicken 50"
		}, new String[] {
			"java and backend and junior and pizza 100",
			"python and frontend and senior and chicken 200",
			"cpp and - and senior and pizza 250",
			"- and backend and senior and - 150",
			"- and - and - and chicken 100",
			"- and - and - and - 150"
		})));
	}
}
