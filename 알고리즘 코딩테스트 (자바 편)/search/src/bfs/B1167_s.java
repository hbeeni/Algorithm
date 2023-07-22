//Do it! 코딩 테스트 - 자바 편 178p

package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1167_s {
    
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] tree;

    static class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            while (true) {
                int y = Integer.parseInt(st.nextToken());

                if (y == -1) {
                    break;
                }

                int distance = Integer.parseInt(st.nextToken());
                tree[x].add(new Edge(y, distance));
            }
        }

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(1); //1번 노드로부터 가장 먼 노드 구하기

        int max = 1;
        for (int i = 2; i <= n ; i++) { //distance 배열에서 가장 큰 값으로 다시 시작점 설정
            if (max < distance[i]) {
                max = i;
            }
        }

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(max); //1번 노드에서 가장 멀었던 노드로부터 가장 먼 노드 구하기 -> 이 길이가 지름

        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            for (Edge edge : tree[curNode]) {
                int e = edge.e;
                int value = edge.value;

                if (!visited[e]) {
                    q.offer(e);
                    visited[e] = true;
                    distance[e] = distance[curNode] + value;
                }
            }
        }
    }
}
