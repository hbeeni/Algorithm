package algorithmcodingtest.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int[] shortest = new int[v + 1];
        boolean[] visited = new boolean[v + 1];

        //graph 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        //최단거리 배열 초기화
        for (int i = 0; i <= v; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, distance));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startIndex, 0));
        shortest[startIndex] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;

            for (Node next : graph.get(now.vertex)) {
                int vertex = next.vertex;
                int value = next.value;

                if (shortest[vertex] > shortest[now.vertex] + value) {
                    shortest[vertex] = shortest[now.vertex] + value;
                    queue.add(new Node(vertex, shortest[vertex]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (visited[i]) {
                System.out.println(shortest[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
