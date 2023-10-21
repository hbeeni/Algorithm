package algorithmcodingtest.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023_s {

    static ArrayList<Integer>[] relations;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        relations = new ArrayList[n];
        visited = new boolean[n];
        arrive = false;

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

        for (int i = 0; i < n; i++) {
            dfs(i, 1);

            if (arrive) {
                break;
            }
        }

        System.out.println(arrive ? 1 : 0);
    }

    private static void dfs(int x, int depth) {
        if (arrive || depth == 5) {
            arrive = true;
            return;
        }

        visited[x] = true;

        for (Integer i : relations[x]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[x] = false;
    }
}
