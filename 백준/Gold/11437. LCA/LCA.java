import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n + 1];

        List<List<Integer>> nodes = new ArrayList<>();
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

        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        depth[1] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : nodes.get(now)) {
                if (!visited[next]) {
                    parent[next] = now;
                    depth[next] = depth[now] + 1;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //같은 깊이로 맞춰주기
            while (depth[a] > depth[b]) {
                a = parent[a];
            }
            while (depth[a] < depth[b]) {
                b = parent[b];
            }
            //공통 조상 찾기
            while (a != b) {
                a = parent[a];
                b = parent[b];
            }
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }
}
