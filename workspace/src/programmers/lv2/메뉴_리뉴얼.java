//https://fbtmdwhd33.tistory.com/249

package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class 메뉴_리뉴얼 {

	static HashMap<String, Integer> map;

	public static List<String> solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();

		//각 문자열 오름차순 정렬
		for (int i = 0; i < orders.length; i++) {
			char[] charArray = orders[i].toCharArray();
			Arrays.sort(charArray);
			orders[i] = String.valueOf(charArray);
		}

		//조합 구하기
		for (int len : course) {
			map = new HashMap<>();
			int max = Integer.MIN_VALUE;

			for (String order : orders) {
				StringBuilder sb = new StringBuilder();
				if (len <= order.length()) {
					combination(order, sb, 0, 0, len);
				}
			}

			findAnswer(max, answer);
		}

		Collections.sort(answer);

		return answer;
	}

	private static void combination(String order, StringBuilder sb, int idx, int count, int len) {
		if (count == len) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}

		for (int i = idx; i < order.length(); i++) {
			sb.append(order.charAt(i));
			combination(order, sb, i + 1, count + 1, len);
			sb.delete(count, count + 1);
		}
	}

	private static void findAnswer(int max, ArrayList<String> answer) {
		for (Entry<String, Integer> entry : map.entrySet()) {
			max = Math.max(max, entry.getValue());
		}

		if (max < 2) {
			return;
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				answer.add(entry.getKey());
			}
		}
	}

	public static void main(String[] args) {
		//["AC", "ACDE", "BCFG", "CDE"]
		System.out.println(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4}));
		//["ACD", "AD", "ADE", "CD", "XYZ"]
		System.out.println(
			solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5})
		);
		//["WX", "XY"]
		System.out.println(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2, 3, 4}));
	}
}
