package algorithmcodingtest.graph.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1414_s {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int sum = 0; //총 랜선의 길이
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                int length = 0;
                if (temp[j] >= 'a' && temp[j] <= 'z') {
                    length = temp[j] -'a' + 1;
                } else if (temp[j] >= 'A' && temp[j] <= 'A') {
                    length = temp[j] -'A' + 27;
                }
                sum += length;
                if (i != j && length != 0) {
                    queue.add(new Edge(i, j, length));
                }
            }
        }

        int usedEdge = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (find(edge.c1) != find(edge.c2)) {
                union(edge.c1, edge.c2);
                result += edge.length;
                usedEdge++;
            }
        }

        if (usedEdge == n - 1) {
            System.out.println(sum - result);
        } else {
            System.out.println(-1);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static class Edge implements Comparable<Edge> {
        int c1;
        int c2;
        int length;

        public Edge(int c1, int c2, int length) {
            this.c1 = c1;
            this.c2 = c2;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return this.length - o.length;
        }
    }
}
