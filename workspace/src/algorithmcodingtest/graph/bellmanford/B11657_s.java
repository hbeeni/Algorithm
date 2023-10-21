package algorithmcodingtest.graph.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11657_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m + 1]; //에지 배열
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

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
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
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
