//시간초과

package algorithmcodingtest.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1167 {
    
    static int d = 0;
    static boolean[] visited;
    static ArrayList<Node>[] tree;

    static class Node {
        int value;
        int distance;

        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
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
                tree[x].add(new Node(y, distance));
            }
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0);
        }

        System.out.println(d);
    }

    private static void dfs(int x, int distance) {
        visited[x] = true;
        d = Math.max(d, distance);

        for (int i = 0; i < tree[x].size(); i++) {
            if (!visited[tree[x].get(i).value]) {
                dfs(tree[x].get(i).value, distance + tree[x].get(i).distance);
            }
        }
    }
}
