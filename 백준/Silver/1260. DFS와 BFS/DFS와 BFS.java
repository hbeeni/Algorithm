import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean visited[];
	static ArrayList<Integer>[] graph;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
		}
		
		for (int i = 1; i <= N; i++)
			Collections.sort(graph[i]);
		
		dfs(V);
		bw.flush();
		System.out.println();
		
		for (int i = 1; i <= N; i++)
			visited[i] = false;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visited[V] = true;
		
		while (!q.isEmpty()) {
			int num = q.poll();
			bw.write(num + " ");
			
			for (int i : graph[num]) {
				if (!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		bw.flush();
	}

	private static void dfs(int v) throws IOException {
		if (visited[v]) return;
		
		visited[v] = true;
		bw.write(v + " ");
		
		for (int i : graph[v]) {
			if (!visited[i])
				dfs(i);
			
		}
	}
}
