package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://jisunshine.tistory.com/150
public class 수식_최대화 {

	private static final String[][] priorities = {
		{"+", "-", "*"},
		{"+", "*", "-"},
		{"-", "+", "*"},
		{"-", "*", "+"},
		{"*", "+", "-"},
		{"*", "-", "+"}
	};

	public static long solution(String expression) {
		StringTokenizer st = new StringTokenizer(expression, "+-*", true);
		List<String> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		long max = Long.MIN_VALUE;
		for (String[] priority : priorities) {
			max = Math.max(max, Math.abs(calculate(new ArrayList<>(list), priority)));
		}

		return max;
	}

	static long calculate(List<String> list, String[] priority) {
		for (String op : priority) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(op)) {
					long n1 = Long.parseLong(list.get(i - 1));
					long n2 = Long.parseLong(list.get(i + 1));
					long result = calculate(n1, n2, op);

					list.remove(i - 1);
					list.remove(i - 1);
					list.remove(i - 1);
					list.add(i - 1, String.valueOf(result));
					i -= 2;
				}
			}
		}
		return Long.parseLong(list.get(0));
	}

	static long calculate(long n1, long n2, String op) {
		switch (op) {
			case "+":
				return n1 + n2;
			case "-":
				return n1 - n2;
			default:
				return n1 * n2;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
		System.out.println(solution("50*6-3*2"));
	}
}
