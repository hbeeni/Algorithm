package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://shoark7.github.io/programming/algorithm/tower-of-hanoi
public class 하노이의_탑 {

	private static List<int[]> answer = new ArrayList<>();

	public static int[][] solution(int n) {
		hanoi(n, 1, 3, 2); //n개의 원판을 1 -> 3으로 옮김 (경유지: 2)
		return answer.toArray(int[][]::new);
	}

	private static void hanoi(int count, int from, int to, int via) {
		if (count == 1) {
			return;
		}

		hanoi(count - 1, from, via, to); //맨 밑의 n번째 원판을 목적지로 옮기기 위해 위의 n-1개의 원판을 경유지로 옮김
		answer.add(new int[] {from, to}); //n번째 원판을 목적지로 옮김
		hanoi(count - 1, via, to, from); //경유지에 있는 n-1개의 원판을 목적지로 옮김
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(4)));
	}
}
