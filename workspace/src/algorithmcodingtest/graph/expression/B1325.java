//시간 초과

package algorithmcodingtest.graph.expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1325 {

    static ArrayList<Integer>[] graph;
    static Set<Integer> set;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        /*
        1 ~ n까지 반복
            set 초기화
            dfs
         */
        int max = 0;
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            set = new HashSet<>();
            visited = new boolean[n + 1];
            dfs(i);

            count[i] = set.size();
            if (set.size() > max) {
                max = set.size();
            }
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    /*
    본인 원소 set에 넣기
    dfs 로직
     */
    private static void dfs(int x) {
        visited[x] = true;
        set.addAll(graph[x]);

        /*
        graph[x]의 size만큼 반복
            graph[x].get(i)를 방문하지 않았으면
                방문
         */
        for (int i = 0; i < graph[x].size(); i++) {
            if (!visited[graph[x].get(i)]) {
                dfs(graph[x].get(i));
            }
        }
    }
}
