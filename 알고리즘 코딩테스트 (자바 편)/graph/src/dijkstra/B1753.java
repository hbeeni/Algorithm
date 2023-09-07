//오답

package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, distance));
        }

        int[] shortest = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i <= v; i++) {
            if (i != startIndex) {
                shortest[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        queue.add(new Node(startIndex, 0));
        visited[startIndex] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            ArrayList<Node> list = graph.get(now.index);

            for (Node next : list) {
                if (!visited[next.index]) {
                    shortest[next.index] = Math.min(shortest[next.index], shortest[now.index] + next.distance);
                    visited[next.index] = true;
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (shortest[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(shortest[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
