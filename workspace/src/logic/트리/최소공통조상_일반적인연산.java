package logic.트리;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/* https://www.acmicpc.net/problem/11437
[입력]
15
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
6
6 11
10 9
2 6
7 6
8 13
8 15

[출력]
2
4
2
1
3
1
 */
public class 최소공통조상_일반적인연산 {

	//질의 개수 10,000개, 노드 개수 50,000개로 비교적 데이터가 크지 않아 일반적인 방식의 LCA 알고리즘으로 구현
	static List<Integer>[] tree;
	static int[] depth;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) {
		//인접 리스트로 트리 데이터 구현
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //노드 수

		tree = new List[n + 1];
		depth = new int[n + 1];
		parent = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			tree[s].add(e);
			tree[e].add(s);
		}

		//탐색(DFS, BFS)을 이용해 각 노드의 깊이와 부모 노드를 구함
		bfs(1);

		//최소 공통 조상 찾기
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(lca(a, b));
		}
	}

	private static int lca(int a, int b) {
		if (depth[a] > depth[b]) { //더 깊은 depth가 b가 되도록 하기
			int temp = a;
			a = b;
			b = temp;
		}

		//깊이를 맞추기 위해 더 깊은 노드를 같은 깊이가 될 때까지 부모 노드로 이동
		while (depth[a] != depth[b]) {
			a = parent[a];
		}

		//부모 노드로 올라가면서 최소 공통 조상을 찾음
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}

	//노드의 깊이, 부모 노드 구하기
	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		int level = 1;
		int nowSize = 1;
		int count = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : tree[now]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					parent[next] = now; //부모 노드 저장
					depth[next] = level; //노드 depth 저장
				}
			}

			count++;

			if (count == nowSize) {
				count = 0;
				nowSize = queue.size();
				level++;
			}
		}
	}
}
