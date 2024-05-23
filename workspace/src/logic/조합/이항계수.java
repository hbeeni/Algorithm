package logic.조합;

import java.util.Scanner;

/* https://www.acmicpc.net/problem/11050
[입력]
5 2

[출력]
10
 */
public class 이항계수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			arr[i][0] = 1; //i개에서 1개도 선택하지 않는 경우의 수 = 1
			arr[i][1] = i; //i개에서 1개 선택하는 경우의 수 = i
			arr[i][i] = 1; //i개에서 모두 선택하는 경우의 수 = 1
		}

		//i개 중 j개를 고름
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) { //j개가 i개를 넘을 수 없음
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]; //조합 기본 점화식
			}
		}

		System.out.println(arr[n][k]);
	}
}
