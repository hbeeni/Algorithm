import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                if (ch == '0') {
                    continue;
                }

                int length = convertLength(ch);
                if (i == j) {
                    answer += length;
                } else {
                    edges.add(new Edge(i, j, length));
                }
            }
        }

        int usedEdge = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (find(edge.c1) != find(edge.c2)) {
                union(edge.c1, edge.c2);
                usedEdge++;
            } else {
                answer += edge.length;
            }

            if (usedEdge == n - 1) {
                break;
            }
        }

        if (usedEdge < n - 1) {
            System.out.println(-1);
        } else {
            while (!edges.isEmpty()) {
                answer += edges.poll().length;
            }
            System.out.println(answer);
        }
    }

    static int convertLength(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return 1 + ch - 'a';
        }
        return 27 + ch - 'A';
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
