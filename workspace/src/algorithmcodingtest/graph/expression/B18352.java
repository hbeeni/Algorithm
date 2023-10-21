package algorithmcodingtest.graph.expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18352 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int k;
    static int depth = 0;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시 개수
        int m = Integer.parseInt(st.nextToken()); //도로 개수
        k = Integer.parseInt(st.nextToken()); //거리 정보
        int x = Integer.parseInt(st.nextToken()); //출발 도시 번호

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        bfs(x);
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.stream()
                    .sorted()
                    .forEach(i -> sb.append(i).append("\n"));
            System.out.println(sb);
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visited[x] = true;
        int count = 1;
        int add = 0;

        while (depth != k) {
            if (queue.isEmpty()) {
                break;
            }

            depth++;

            for (int i = 0; i < count; i++) {
                int num = queue.poll();

                for (int j = 0; j < graph[num].size(); j++) {
                    int temp = graph[num].get(j);
                    if (!visited[temp]) {
                        add++;
                        queue.add(temp);
                        visited[temp] = true;
                    }
                }
            }
            count = add;
            add = 0;
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
    }
}
