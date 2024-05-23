package logic.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1번부터 n번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다. (길이 없을 수도 있다)
한 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획하려고 한다.
단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
이런 여행 경로는 여러 가지가 있을 수 있는데, 가장 적은 비용을 들이는 여행 계획을 세우고자 한다.

[입력]
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

[출력]
35
 */
public class 외판원순회_tsp {
	private static final int INF = 1000000 * 16 + 1;
	private static int n;
	private static int[][] w; //i -> j 로 가는 데 드는 비용
	private static int[][] d; //d[c][v] = 현재 도시가 c, 현재까지 방문한 모든 도시 리스트가 v일 때 앞으로 남은 모든 도시를 경유하는 데 필요한 최소 비용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 1 << n; j++) {
				d[i][j] = INF; //모든 비용을 충분히 큰 수로 저장
			}
		}

		System.out.println(tsp(0, 1));
	}

	//모든 경우의 수와 관련된 완전 탐색하고 재귀 구현
	private static int tsp(int c, int v) {
		if (v == (1 << n) - 1) { //모든 도시를 방문할 때
			//시작 도시로 돌아갈 수 있을 때 -> return w[c][시작 도시]
			//시작 도시로 돌아갈 수 없을 때 -> return 무한대
			return w[c][0] == 0 ? INF : w[c][0];
		}
		if (d[c][v] != INF) { //이미 계산한 적이 있을 때 -> 바로 리턴 (memoization)
			return d[c][v];
		}
		for (int i = 0; i < n; i++) {
			if ((v & (1 << i)) == 0 && w[c][i] != 0) { //방문한 적이 없고, 갈 수 있는 도시일 때
				d[c][v] = Math.min(d[c][v], tsp(i, (v | (1 << i))) + w[c][i]);
			}
		}
		return d[c][v];
	}
}
