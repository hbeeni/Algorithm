package logic.기하;

import java.util.Scanner;

/*
2차원 평면상에 N(3 ≤ N ≤ 10,000)개의 점으로 이루어진 다각형이 있다. 이 다각형의 면적을 구하는 프로그램을 작성하시오.
첫째 줄에 N이 주어진다. 다음 N개의 줄에는 다각형을 이루는 순서대로 N개의 점의 x, y좌표가 주어진다.
좌표값은 절댓값이 100,000을 넘지 않는 정수이다.

[입력]
4
0 0
0 10
10 10
10 0

[출력]
100.0
 */
public class CCW_다각형넓이 {
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

		/*
		CCW 절댓값 = 세 점의 벡터 외적 = 세 점을 기준으로 하는 평행사변형 넓이
		즉, CCW 절댓값 / 2 = 세 점을 꼭짓점으로 하는 삼각형 넓이

		원점과 다른 두 점 사이의 CCW를 계산한다.
		이 때 반시계 방향이면 양수, 시게 방향이면 음수가 나온다.
		결과 = 반 시계 방향인 양수 넓이 합(다각형 넓이 + 원점과 다각형 사이 넓이) - 시계 방향인 음수 넓이 합(원점과 다각형 사이 넓이)
		 */
		double result = 0;
		for (int i = 0; i < n; i++) {
			//원점과 다른 두 점 사이의 CCW 공식을 단순화 = x1y2 - x2y1
			result += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
		}

		System.out.printf("%.1f", Math.abs(result) / 2.0);
	}
}
