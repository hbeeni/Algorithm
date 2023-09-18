package minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1197_s {

    static int[] parent; //대표 노드 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //정점
        int e = Integer.parseInt(st.nextToken()); //간선

        PriorityQueue<Edge> queue = new PriorityQueue<>();//자동 정렬을 위해 우선순위 큐 사용
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.add(new Edge(node1, node2, value));
        }

        parent = new int[v + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int usedEdge = 0;
        int result = 0;
        while (usedEdge < v - 1) {
            Edge edge = queue.poll();
            if (find(edge.node1) != find(edge.node2)) { //같은 부모가 아니라면 연결해도 사이클이 생기지 않음
                union(edge.node1, edge.node2);
                result += edge.value;
                usedEdge++;
            }
        }

        System.out.println(result);
    }

    static void union(int i, int j) { //대표 노드끼리 연결
        i = find(i);
        j = find(j);

        if (i != j) {
            parent[j] = i;
        }
    }

    static int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    private static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int value;

        public Edge(int node1, int node2, int value) {
            this.node1 = node1;
            this.node2 = node2;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
