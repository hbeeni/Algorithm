package logic.탐색;

import static logic.탐색.Util.*;

import java.util.ArrayList;
import java.util.Collections;

//https://www.acmicpc.net/problem/1260
public class DFS {

	static int n = NODE_COUNT;
	static ArrayList<Integer>[] graph = GRAPH;
	static boolean[] visited = new boolean[n + 1];

	public static void main(String[] args) {
		for (int i = 1; i <= n; i++) { //번호가 작은 거부터 방문하기 위해 정렬
			Collections.sort(graph[i]);
		}

		dfs(1);
	}

	static void dfs(int node) {
		System.out.print(node + " ");
		visited[node] = true;

		for (int i : graph[node]) {
			if (!visited[i]) { //연결 노드 중 방문하지 않았던 노드만 탐색
				dfs(i);
			}
		}
	}
}
