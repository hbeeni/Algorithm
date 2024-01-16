package logic.탐색;

import java.util.ArrayList;

//https://www.acmicpc.net/problem/1260
public abstract class Util {

	/*
	1 -> 2 3 4
	2 -> 4 1
	3 -> 4 1
	4 -> 1 2 3
	 */
	public static final int NODE_COUNT;
	public static final ArrayList<Integer>[] GRAPH;

	static {
		NODE_COUNT = 4;
		GRAPH = new ArrayList[NODE_COUNT + 1];

		for (int i = 1; i <= NODE_COUNT; i++) {
			GRAPH[i] = new ArrayList<>();
		}

		GRAPH[1].add(2);
		GRAPH[2].add(1);

		GRAPH[1].add(3);
		GRAPH[3].add(1);

		GRAPH[1].add(4);
		GRAPH[4].add(1);

		GRAPH[2].add(4);
		GRAPH[4].add(2);

		GRAPH[3].add(4);
		GRAPH[4].add(3);
	}

	private Util() {
	}
}
