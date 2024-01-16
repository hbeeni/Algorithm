package logic.탐색;

import static logic.탐색.Util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/1260
public class BFS {

	static int n = NODE_COUNT;
	static ArrayList<Integer>[] graph = GRAPH;
	static boolean[] visited = new boolean[n + 1];

	public static void main(String[] args) {
		for (int i = 1; i <= n; i++) { //번호가 작은 거부터 방문하기 위해 정렬
			Collections.sort(graph[i]);
		}

		bfs(1);
	}

	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			System.out.print(nowNode + " ");

			for (int i : graph[nowNode]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
