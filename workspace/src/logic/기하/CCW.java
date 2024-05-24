package logic.기하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/11758
[입력]
1 1
5 5
7 3

[출력]
-1
 */
public class CCW {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] x = new int[4];
		int[] y = new int[4];

		for (int i = 1; i <= 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		//(x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3)
		int result = (x[1] * y[2] + x[2] * y[3] + x[3] * y[1]) - (x[2] * y[1] + x[3] * y[2] + x[1] * y[3]);
		if (result < 0) {
			System.out.println(-1);
		} else if (result == 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}
}
