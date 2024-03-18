import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	static List<List<Town>> graph;
	static boolean[] visited;
	static Set<Integer> set = new HashSet<>();

	public int solution(int n, int[][] road, int k) {
		graph = new ArrayList<>();
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] roadInfo : road) {
			int s = roadInfo[0];
			int e = roadInfo[1];
			int h = roadInfo[2];

			graph.get(s).add(new Town(e, h));
			graph.get(e).add(new Town(s, h));
		}

		dfs(1, 0, k);

		return set.size();
	}

	private static void dfs(int node, int hour, int k) {
		if (visited[node]) {
			return;
		}

		visited[node] = true;
		set.add(node);

		for (Town next : graph.get(node)) {
			if (!visited[next.dest] && hour + next.hour <= k) {
				dfs(next.dest, hour + next.hour, k);
				visited[next.dest] = false;
			}
		}
	}

	static class Town {

		int dest;
		int hour;

		public Town(int dest, int hour) {
			this.dest = dest;
			this.hour = hour;
		}
	}
}
