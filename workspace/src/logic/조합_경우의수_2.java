package logic;

public class 조합_경우의수_2 {
	public static void main(String[] args) {
		int n = 5;
		int[][] a = new int[n + 1][n + 1];

		/**
		 * 조합 점화식
		 * a[i][j] = a[i - 1][j] + a[i - 1][j - 1]
		 * ex) 5개 중 3개를 선택해는 경우의 수 = 4개 중 2개를 선택하는 경우 + 4개 중 3개를 선택하는 경우
		 */
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					a[i][j] = 1;
				} else {
					a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
				}
			}
		}

		//i 중 j개를 고르는 경우의 수
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
