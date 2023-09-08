package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 다익스트라_최단거리 {
    public static void main(String[] args) throws IOException {
        int v = 5; //정점
        int e = 6; //간선
        int startIndex = 1; //시작점

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int[] shortest = new int[v + 1]; //최단거리 배열
        boolean[] visited = new boolean[v + 1]; //방문여부 배열

        //graph 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        //최단거리 배열 초기화
        //Arrays.fill(shortest, Integer.MAX_VALUE);
        for (int i = 0; i <= v; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }

        //graph 입력
        graph.get(5).add(new Node(1, 1));
        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 3));
        graph.get(2).add(new Node(3, 4));
        graph.get(2).add(new Node(4, 5));
        graph.get(3).add(new Node(4, 6));

        //다익스트라 로직
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

        //최단경로의 경로값 출력
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
