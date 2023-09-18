package logic;

import java.io.IOException;
import java.util.PriorityQueue;

public class 최소신장트리_가중치합최소 {

    static int[] parent; //대표 노드 저장 배열

    public static void main(String[] args) throws IOException {
        int v = 3; //정점
        int e = 3; //간선

        /**
         * 1. 에지 리스트로 그래프를 구현하고 유니온 파인드 배열 초기화하기
         * 2. 그래프 데이터를 가중치 기준으로 정렬하기
         * - 한 번에 하기 위해 PriorityQueue 사용
         */
        PriorityQueue<Edge> queue = new PriorityQueue<>();//자동 정렬을 위해 우선순위 큐 사용
        queue.add(new Edge(1, 2, 1));
        queue.add(new Edge(2, 3, 2));
        queue.add(new Edge(1, 3, 3));

        parent = new int[v + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        /**
         * 3. 가중치가 낮은 에지부터 연결 시도하기
         * - 사이클 형성 유무를 find()로 확인 후 사이클이 형성되지 않을 때만 union()을 이용해 노드 연결
         * - 연결한 에지 수 = 정점 - 1이 될 때까지 반복
         */
        int usedEdge = 0; //연결한 에지 수
        int result = 0; //총 에지 비용
        while (usedEdge < v - 1) {
            Edge edge = queue.poll();
            if (find(edge.node1) != find(edge.node2)) { //같은 부모가 아니라면 연결해도 사이클이 생기지 않음
                union(edge.node1, edge.node2);
                result += edge.value;
                usedEdge++;
            }
        }

        /**
         * 총 에지 비용 출력
         */
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
