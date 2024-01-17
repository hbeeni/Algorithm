import java.util.Stack;

class Solution {
	public static String solution(String p) {
		if (isValid(p)) {
			return p;
		}

		return makeValidBracketString(p);
	}

	private static String makeValidBracketString(String str) {
		if (str.isEmpty()) {
			return "";
		}

		String result = "";
		String u = "";
		String v = "";
		int left = 0;
		int right = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}

			if (left == right) {
				u = str.substring(0, i + 1);
				v = str.substring(i + 1);
				break;
			}
		}

		if (isValid(u)) {
			result += u + makeValidBracketString(v);
		} else {
			result += "(" + makeValidBracketString(v) + ")" + convertString(u);
		}

		return result;
	}

	private static boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		stack.add(str.charAt(0));

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add('(');
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			} else {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	private static String convertString(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '(') {
				sb.append(')');
			} else {
				sb.append('(');
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}
}
