package logic.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/11657
[입력]
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

[출력]
4
3
 */
public class 벨만포드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[m + 1];
		long[] distance = new long[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, time);
		}

		//[벨만-포드]
		//1. 모든 에지와 관련된 정보를 가져온 후 다음 조건에 따라 거리 배열 값 업데이트
		//   - 출발 노드가 방문한 적이 없는 노드일 때 값을 업데이트하지 않는다.
		//   - 출발 노드의 거리 배열값 + 에지 가중치 < 종료 노드의 거리 배열값일 때 종료 노드의 거리 배열값을 업데이트한다.
		//2. '노드 개수 - 1' 번만큼 1을 반복한다.
		//3. 음수 사이클 유무를 알기 위해 모든 에지에 관해 1을 다시 수행한다. 이 때 한 번이라도 값이 업데이트 되면 음수사이클이 존재한다고 판단한다.

		distance[1] = 0;
		for (int i = 1; i < n; i++) { //n - 1만큼 반복 ---> 음수 사이클이 없을 때 특정 두 노드의 최단 거리를 구성할 수 있는 에지의 최대 개수는 n - 1이기 때문
			for (int j = 0; j < m; j++) {
				Edge edge = edges[j];
				if (distance[edge.start] != Integer.MAX_VALUE &&
					distance[edge.end] > distance[edge.start] + edge.time) { //더 작은 최단거리가 있을 때 업데이트
					distance[edge.end] = distance[edge.start] + edge.time;
				}
			}
		}

		//음수 사이클 확인
		boolean minucCycle = false;
		for (int j = 0; j < m; j++) {
			Edge edge = edges[j];
			if (distance[edge.start] != Integer.MAX_VALUE &&
				distance[edge.end] > distance[edge.start] + edge.time) { //더 작은 최단거리가 있을 때 업데이트
				minucCycle = true;
				break;
			}
		}

		if (minucCycle) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= n; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(distance[i]);
				}
			}
		}
	}

	static class Edge {
		int start;
		int end;
		int time;

		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
}
