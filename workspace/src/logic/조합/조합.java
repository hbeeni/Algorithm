package logic.조합;

public class 조합 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int n = arr.length;

		boolean[] visited = new boolean[n];

		for (int i = 1; i <= n; i++) {
			System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
			//combination(arr, visited, 0, n, i);
			combination2(arr, visited, 0, 0, i);
		}

	}

	/**
	 * nCr = n개 중 r개를 뽑는다.
	 *
	 * @param arr 조합을 뽑아낼 배열
	 * @param visited 조합에 뽑혔는지 체크하는 배열
	 * @param start 시작 인덱스
	 * @param n 전체 수의 개수
	 * @param r 뽑아야 하는 수의 개수 = 조합의 길이
	 */
	private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			print(arr, visited);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	/**
	 * @param arr 조합을 뽑아낼 배열
	 * @param visited 조합에 뽑혔는지 체크하는 배열
	 * @param start 시작 인덱스
	 * @param n 현재 뽑은 수의 개수
	 * @param target 뽑아야 하는 수의 개수 = 조합의 길이
	 */
	private static void combination2(int[] arr, boolean[] visited, int start, int n, int target) {
		if (n == target) {
			print(arr, visited);
			return;
		}

		for (int i = start; i < visited.length; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			combination2(arr, visited, i, n + 1, target);
			visited[i] = false;
		}
	}

	/**
	 * 조합의 결과를 출력한다.
	 */
	private static void print(int[] arr, boolean[] visited) {
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				System.out.print(arr[i] + " ");
			}
		}

		System.out.println();
	}
}
