package logic.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/1753
[입력]
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

[출력]
0
2
3
7
INF
 */
public class 다익스트라 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int[] distance = new int[v + 1];
		boolean[] visited = new boolean[v + 1];
		ArrayList<Edge>[] list = new ArrayList[v + 1];

		//1. 인접 리스트에 노드를 저장하고 거리 배열을 초기화
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Edge(b, c));
		}

		for (int i = 0; i <= v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		//2. 최초 시작점을 큐에 삽입
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(k, 0));
		distance[k] = 0;

		//3. 다익스트라 수행
		//3-1. 거리 배열에서 아직 방문하지 않은 노드 중 현재 값이 가장 작은 노드를 선택
		//3-2. 해당 노드와 연결된 노드들의 최단 거리 값 업데이트
		//3-3. 큐가 빌 때까지 1~2 반복
		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int vertex = current.vertex;

			if (visited[vertex]) { //이미 방문한 적이 있는 노드는 다시 큐에 넣지 않음
				continue;
			}

			visited[vertex] = true;

			for (int i = 0; i < list[vertex].size(); i++) {
				Edge edge = list[vertex].get(i);
				int next = edge.vertex;
				int value = edge.value;

				if (distance[next] > distance[vertex] + value) { //최소 거리로 업데이트
					distance[next] = distance[vertex] + value;
					pq.add(new Edge(next, distance[next]));
				}
			}
		}

		//답(거리 배열) 출럭
		for (int i = 1; i <= v; i++) {
			if (visited[i]) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}
	}

	static class Edge implements Comparable<Edge> {

		int vertex;
		int value;

		public Edge(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}

		@Override
		public int compareTo(Edge e) {
			return this.value - e.value;
		}
	}
}
