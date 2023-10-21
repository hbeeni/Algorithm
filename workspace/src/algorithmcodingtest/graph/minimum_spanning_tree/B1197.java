package algorithmcodingtest.graph.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1197 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //정점
        int e = Integer.parseInt(st.nextToken()); //간선

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new Edge(node1, node2, value));
        }
        Collections.sort(edges);

        arr = new int[v + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int count = 0;
        int answer = 0;
        for (Edge edge : edges) {
            if (find(edge.node1) != find(edge.node2)) {
                count++;
                answer += edge.value;
                union(edge.node1, edge.node2);
            }
            if (count == v - 1) {
                break;
            }
        }
        System.out.println(answer);
    }

    static int find(int i) {
        if (arr[i] == i) {
            return i;
        }

        return arr[i] = find(arr[i]);
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            arr[j] = i;
        }
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
