package algorithmcodingtest.tree.lowest_common_ancestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11437_s {

    static List<List<Integer>> nodes;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        //데이터 입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        //부모 노드, 깊이 배열 초기화
        parent = new int[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];
        bfs();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(executeLCA(a, b));
        }
    }

    private static int executeLCA(int a, int b) {
        //같은 깊이로 맞춰주기
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (depth[a] != depth[b]) {
            a = parent[a];
        }
        //공통 조상 찾기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int level = 1;
        int nowSize = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : nodes.get(now)) {
                if (!visited[next]) {
                    parent[next] = now;
                    depth[next] = level;
                    visited[next] = true;
                    queue.add(next);
                }
            }

            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }
    }
}
