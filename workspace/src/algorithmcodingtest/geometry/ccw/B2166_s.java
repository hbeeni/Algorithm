package algorithmcodingtest.geometry.ccw;

import java.util.Scanner;

public class B2166_s {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[] x = new long[n + 1];
		long[] y = new long[n + 1];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		//마지막 점과 처음 점도 CCW 계산에 포함해야 함
		x[n] = x[0];
		y[n] = y[0];

		double result = 0;
		for (int i = 0; i < n; i++) {
			//원점과 다른 두 점 사이의 CCW 공식을 단순화 = x1y2 - x2y1
			result += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
		}

		System.out.printf("%.1f", Math.abs(result) / 2.0);
	}
}
