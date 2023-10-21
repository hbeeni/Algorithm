//시간 초과

package algorithmcodingtest.graph.expression;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325_s {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
        }

        /*
        for (1 ~= n)
            visited 배열 초기화
            bfs
         */
        answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        /*
        for(1 ~= n)
            answer 배열에서 max 찾기
         */
        int max = 0;
        for (int count : answer) {
            max = Math.max(max, count);
        }

        /*
        for(1 ~= n)
            answer[i] == max -> 정답 출력
         */
        for (int i = 1; i <= n; i++) {
            if (answer[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.flush();
    }

    private static void bfs(int x) {
        /*
        큐에 출발 노드 더하기
        visited에 현재 노드 방문 기록
        while (큐가 빌 때까지)
            큐에서 노드 데이터 가져오기
            현재 노드의 연결 노드 중 방문하지 않은 노드로
            큐에 데이터 삽입, visited 방문 기록
            신규 노드 인덱스의 정답 배열 값 증가
         */
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int currentNode : graph[node]) {
                if (!visited[currentNode]) {
                    visited[currentNode] = true;
                    queue.add(currentNode);
                    answer[currentNode]++;
                }
            }
        }
    }
}
