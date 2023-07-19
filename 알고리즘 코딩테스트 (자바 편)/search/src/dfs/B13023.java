//못품

package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023 {

    static ArrayList<Integer>[] relations;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        relations = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations[a].add(b);
            relations[b].add(a);
        }

        boolean exist = false;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            int depth = dfs(i, 1);

            if (depth >= 4) {
                exist = true;
                break;
            }
        }

        System.out.println(exist ? 1 : 0);
    }

    private static int dfs(int x, int depth) {
        if (depth >= 4) {
            return depth;
        }

        visited[x] = true;

        for (int i = 0; i < relations[x].size(); i++) {
            if (!visited[relations[x].get(i)]) {
                depth = dfs(relations[x].get(i), depth + 1);
            }
        }

        return depth;
    }
}
