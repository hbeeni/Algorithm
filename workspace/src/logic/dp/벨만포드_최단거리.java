package logic.dp;

import java.io.IOException;
import java.util.Arrays;

public class 벨만포드_최단거리 {
    public static void main(String[] args) throws IOException {
        int n1 = 3;
        int m1 = 4;
        Edge[] edges1 = new Edge[m1 + 1];
        edges1[0] = new Edge(1, 2, 4);
        edges1[1] = new Edge(1, 3, 3);
        edges1[2] = new Edge(2, 3, -1);
        edges1[3] = new Edge(3, 1, -2);

        int n2 = 3;
        int m2 = 4;
        Edge[] edges2 = new Edge[m2 + 1];
        edges2[0] = new Edge(1, 2, 4);
        edges2[1] = new Edge(1, 3, 3);
        edges2[2] = new Edge(2, 3, -4);
        edges2[3] = new Edge(3, 1, -2);

        int n3 = 3;
        int m3 = 2;
        Edge[] edges3 = new Edge[m3 + 1];
        edges3[0] = new Edge(1, 2, 4);
        edges3[1] = new Edge(1, 2, 3);

        bellmanFord(n1, m1, edges1);
        bellmanFord(n2, m2, edges2);
        bellmanFord(n3, m3, edges3);
    }

    /**
     * @param n 노드(정점) 개수
     * @param m 에지 개수
     * @param edges 에지 배열
     */
    private static void bellmanFord(int n, int m, Edge[] edges) {
        long[] distance = new long[n + 1]; //최단 거리 배열
        for (int i = 2; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        /**
         * 1. 모든 에지와 관련된 정보를 가져온 후 다음 조건에 따라 거리 배열의 값을 업데이트한다.
         *    - 출발 노드가 방문한 적이 없는 노드(출발 노드 거리 == INF)일 때 값을 업데이트하지 않는다.
         *    - 출발 노드의 거리 배열값 + 에지 가중치 < 종료 노드의 거리 배열값일 때 종료 노드의 거리 배열값을 업데이트한다.
         * 2. '노드개수 - 1'번 만큼 반복한다.
         * 3. 음수 사이클 유무를 알기 위해 모든 에지에 관해 1을 수행한다.
         *    - 한 번이라도 값이 업데이트되면 음수 사이클이 존재한다고 판단한다.
         */
        for (int i = 1; i < n; i++) { //n - 1 만큼 반복
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                //더 작은 최단거리가 있을 때 업데이트
                if (distance[edge.start] != Integer.MAX_VALUE &&
                        distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        //음수 사이클 유무 확인
        boolean minusCycle = false;
        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE &&
                    distance[edge.end] > distance[edge.start] + edge.time) {
                minusCycle = true;
                break;
            }
        }

        if (minusCycle) {
            System.out.println("음수 사이클 존재");
        } else {
            System.out.println("distance = " + Arrays.toString(distance));
        }
    }

    static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
