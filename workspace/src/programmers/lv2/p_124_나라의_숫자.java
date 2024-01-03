//https://blog.itcode.dev/posts/2021/12/27/programmers-a0070

package programmers.lv2;

public class p_124_나라의_숫자 {
	public static String solution(int n) {
		String[] arr = {"4", "1", "2"};
		String answer = "";

		while (n > 0) {
			int remainder = n % 3;
			n /= 3;

			//3의 배수일 경우, 자릿수가 하나 올라가기 때문에 n에 1을 빼서 보정해줘야 한다.
			if (remainder == 0) {
				n--;
			}

			answer = arr[remainder] + answer;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(4)); //11
		System.out.println(solution(9)); //24
		System.out.println(solution(10)); //41
	}
}
