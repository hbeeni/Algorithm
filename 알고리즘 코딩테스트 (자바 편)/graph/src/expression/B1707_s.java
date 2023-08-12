//273p

package expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1707_s {

    static ArrayList<Integer>[] graph;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); //정점 개수
            int e = Integer.parseInt(st.nextToken()); //간선 개수

            graph = new ArrayList[v + 1];
            check = new int[v + 1];
            visited = new boolean[v + 1];
            isEven = true;

            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<>();
            }

            //인접 리스트로 그래프 저장
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            //주어진 그래프가 1개로 연결되었다는 보장이 없음 -> 모든 노드에서 수행
            //각 노드에서 dfs 실행 -> 결과가 이분 그래프가 아니면 반복 종료
            for (int j = 1; j <= v; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if (isEven) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node) {
        /*
        visited 배열에 현재 노드 방문 기록
        if (현재 노드의 연결 노드 중 방문하지 않은 노드로)
            현재 노드와 다른 집합으로 연결 노드 집합 저장
            dfs 실행
        else
            이미 방문한 노드인데, 현재 나의 노드와 같은 집합이면
                이분 그래프 X
         */
        visited[node] = true;
        for (int i : graph[node]) {
            if (!visited[i]) {
                //인접한 노드는 다른 집합으로 처리
                check[i] = (check[node] + 1) % 2;
                dfs(i);
            } else {
                if (check[i] == check[node]) {
                    isEven = false;
                }
            }
        }
    }
}
