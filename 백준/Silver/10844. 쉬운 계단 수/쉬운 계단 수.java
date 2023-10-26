import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();

		int[][] arr = new int[n + 1][10];

		for (int i = 0; i <= 9; i++) {
			if (i == 0) {
				arr[1][i] = 0;
			} else {
				arr[1][i] = 1;
			}
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j > 0 && j < 9) {
					arr[i][j] += arr[i - 1][j - 1] + arr[i - 1][j + 1];
				} else if (j == 0) {
					arr[i][j] += arr[i - 1][j + 1];
				} else if (j == 9) {
					arr[i][j] += arr[i - 1][j - 1];
				}

				arr[i][j] %= 1_000_000_000;
			}
		}

		long result = 0;

		for (int i = 0; i <= 9; i++) {
			result += arr[n][i];
		}

		System.out.println(result % 1_000_000_000);
	}
}