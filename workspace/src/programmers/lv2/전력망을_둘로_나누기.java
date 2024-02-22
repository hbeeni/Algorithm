package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://isshosng.tistory.com/162
public class 전력망을_둘로_나누기 {
	static ArrayList<Integer>[] graph;
	static int min;

	static int solution(int n, int[][] wires) {
		graph = new ArrayList[n + 1];
		min = Integer.MAX_VALUE;

		//그래프 초기화
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		//간선 추가
		for (int i = 0; i < wires.length; i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		//간선을 하나씩 제거하면서 두 그룹으로 분리
		for (int i = 0; i < wires.length; i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];

			//간선 제거
			graph[v1].remove(Integer.valueOf(v2));
			graph[v2].remove(Integer.valueOf(v1));

			//dfs로 그룹에 포함된 노드 개수 구하기
			boolean[] visited = new boolean[n + 1];
			int count = dfs(1, visited);
			// int count = bfs(visited);

			//최소값 갱신
			int diff = Math.abs(count - (n - count));
			min = Math.min(min, diff);

			//간선 다시 추가
			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		return min;
	}

	static int dfs(int node, boolean[] visited) {
		visited[node] = true;
		int count = 1;

		for (int next : graph[node]) {
			if (!visited[next]) {
				count += dfs(next, visited);
			}
		}

		return count;
	}

	static int bfs(boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int next : graph[node]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
		int[][] wires2 = {{1, 2}, {2, 3}, {3, 4}};
		int[][] wires3 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};

		System.out.println(solution(9, wires1)); //3
		System.out.println(solution(4, wires2)); //0
		System.out.println(solution(7, wires3)); //1
	}
}
