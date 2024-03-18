package logic.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/11438
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
public class 최소공통조상_빠른연산 {

	//질의 개수 100,000개, 노드 개수 100,000개로 데이터가 큼 -> 일반적인 연산으로는 시간 초과 발생
	static List<Integer>[] tree;
	static int[] depth;
	static int kMax = 0;
	static int[][] parent;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		//인접 리스트로 트리 데이터 구현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //노드 개수

		tree = new List[n + 1];
		depth = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			tree[s].add(e);
			tree[e].add(s);
		}

		//탐색(DFS, BFS)을 이용해 각 노드의 깊이와 부모 노드를 구함
		int temp = 1;
		while (temp <= n) {
			temp <<= 1;
			kMax++;
		}

		parent = new int[kMax + 1][n + 1];
		bfs(1);

		//점화식을 사용해 Parent 배열(부모 노드 배열) 구하기
		for (int i = 1; i <= kMax; i++) {
			for (int j = 1; j <= n; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}

		//최소 공통 조상 구하기
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(lca(a, b));
		}
	}

	private static int lca(int a, int b) {
		if (depth[a] > depth[b]) { //더 깊은 depth가 b가 되도록 하기
			int temp = a;
			a = b;
			b = temp;
		}

		//깊이가 큰 노드는 Parent 배열을 이용해 2^k만큼 빠르게 이동시켜 깊이 맞추기
		for (int i = kMax; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[b] - depth[a] && depth[a] <= depth[parent[i][b]]) {
				b = parent[i][b];
			}
		}

		//Parent 배열을 이용해 2^k만큼 부모 노드로 올라가면서 최소 공통 조상 찾기 (k는 depth의 최댓값에서 1씩 감소)
		for (int i = kMax; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b];
			}
		}

		int lca = a;

		if (a != b) {
			lca = parent[0][lca];
		}

		return lca;
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
					parent[0][next] = now; //부모 노드
					depth[next] = level; //노드 깊이
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
