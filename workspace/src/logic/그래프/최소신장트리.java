package logic.그래프;

import java.util.PriorityQueue;
import java.util.Scanner;

/* https://www.acmicpc.net/problem/1197
[입력]
3 3
1 2 1
2 3 2
1 3 3

[출력]
2
 */
public class 최소신장트리 {

	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 에지 리스트에 에지 정보를 저장한 후 부모 노드 데이터를 초기화
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		parent = new int[n + 1]; //유니온파인드

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			pq.add(new Edge(s, e, w));
		}

		// 크루스칼 알고리즘
		// 현재 미사용 에지 중 가중치가 가장 작은 에지를 선택하고, 이 에지를 연결했을 때 사이클 발생 유무 판단
		// 사이클 발생 시 생략, 발생하지 않으면 에지값 더하기
		// 에지를 더한 횟수가 '노드 개수 - 1' 이 될 때까지 반복
		// 에지의 가중치를 모두 더한 값 출력
		int useEdge = 0;
		int result = 0;

		while (useEdge < n - 1) {
			Edge now = pq.poll();
			if (find(now.s) != find(now.e)) { //같은 부모가 아니라면 연결해도 사이클이 생기지 않음
				union(now.s, now.e);
				result += now.w;
				useEdge++;
			}
		}

		System.out.println(result);
	}

	//대표 노드끼리 연결
	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	//대표 노드 찾기
	static int find(int a) {
		if (a == parent[a]) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}

	static class Edge implements Comparable<Edge> {

		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			return this.w - e.w; //가중치 오름차순
		}
	}
}
