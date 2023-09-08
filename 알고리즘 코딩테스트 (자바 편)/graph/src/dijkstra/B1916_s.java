package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916_s {
    static ArrayList<ArrayList<Node>> graph;
    static int[] costs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        costs = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        System.out.println(dijkstra(start, end));
        br.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        costs[start] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (!visited[now.vertex]) {
                visited[now.vertex] = true;
                for (Node next : graph.get(now.vertex)) {
                    if (!visited[next.vertex] && costs[next.vertex] > costs[now.vertex] + next.cost) {
                        costs[next.vertex] = costs[now.vertex] + next.cost;
                        queue.add(new Node(next.vertex, costs[next.vertex]));
                    }
                }
            }
        }

        return costs[end];
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
