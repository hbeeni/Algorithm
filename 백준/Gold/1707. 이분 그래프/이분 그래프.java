import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); //정점 개수
            int e = Integer.parseInt(st.nextToken()); //간선 개수

            graph = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            result = new int[v + 1];
            result[1] = 1;

            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            //이분 그래프 구하는 로직
            boolean possible = false;
            for (int j = 1; j <= v; j++) {
                if (!visited[j]) {
                    possible = bfs(j);
                }
                if (!possible) {
                    break;
                }
            }

            if (possible) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.add(x);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int currentNode : graph[node]) {
                if (!visited[currentNode]) {
                    visited[currentNode] = true;
                    queue.add(currentNode);
                }

                /*
                result[현재 노드] = 0이면
                    result[노드]가 1이면 2, 2면 1
                result[현재 노드] = 0이 아니면
                    result[현재 노드] = result[노드]면
                        return false;
                 */
                if (result[currentNode] == 0) {
                    result[currentNode] = result[node] == 1 ? 2 : 1;
                } else {
                    if (result[currentNode] == result[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
