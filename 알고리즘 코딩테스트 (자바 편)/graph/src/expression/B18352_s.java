package expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18352_s {

    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int n, m, k, x;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //도시 개수
        m = Integer.parseInt(st.nextToken()); //도로 개수
        k = Integer.parseInt(st.nextToken()); //거리 정보
        x = Integer.parseInt(st.nextToken()); //출발 도시 번호
        graph = new ArrayList[n + 1];
        visited = new int[n + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
        }

        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }

        //bfs 실행하기
        bfs(x);

        //for(N의 개수만큼 반복하기) {
        //    방문 거리가 k인 노드의 숫자를 정답 배열에 더하기
        //}
        for (int i = 0; i <= n; i++) {
            if (visited[i] == k) {
                result.add(i);
            }
        }

        //정답 배열 오름차순 정렬해 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            result.forEach(System.out::println);
        }
    }

    private static void bfs(int x) {
        //큐에 출발 노드 더하기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        //visited 배열에 현재 노드 방문 기록
        visited[x]++;

        //while (큐가 빌 때까지) {
        //    큐에서 노드 데이터 가져오기
        //    가져온 노드 출력
        //    현재 노드의 연결 노드 중 방문하지 않은 노드로
        //    큐에 데이터 삽입하고 visited 배열에 방문 거리 기록
        //    -> 이전 노드 방문 거리 + 1
        //}
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : graph[node]) {
                if (visited[i] == -1) {
                    visited[i] = visited[node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
