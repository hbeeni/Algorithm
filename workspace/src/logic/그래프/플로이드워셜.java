package logic.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/11404
[입력]
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

[출력]
0 2 3 1 4
12 0 15 2 5
8 5 0 1 1
10 7 13 0 3
7 4 10 6 0
 */
public class 플로이드워셜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int maxValue = 10000001; //덧셈 연산을 수행하기 때문에 Integer.MAX_VALUE 사용 xx. 충분히 큰 수 사용
		int[][] distance = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					distance[i][j] = 0;
				} else {
					distance[i][j] = maxValue;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (distance[s][e] > v) {
				distance[s][e] = v;
			}
		}

		//플로이드-워셜
		for (int k = 1; k <= n; k++) { //경유지 ----> 순서 중요! k가 제일 바깥쪽
			for (int i = 1; i <= n; i++) { //출발
				for (int j = 1; j <= n; j++) { //도착
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (distance[i][j] == maxValue) {
					System.out.print("0 ");
				} else {
					System.out.print(distance[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
