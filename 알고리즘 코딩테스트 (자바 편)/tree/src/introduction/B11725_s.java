package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_s {

    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value1 = Integer.parseInt(st.nextToken());
            int value2 = Integer.parseInt(st.nextToken());
            tree[value1].add(value2);
            tree[value2].add(value1);
        }

        dfs(1); //부모노드부터 dfs 시작

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    static void dfs(int i) {
        visited[i] = true;

        for (int node : tree[i]) {
            if (!visited[node]) {
                answer[node] = i;
                dfs(node);
            }
        }
    }

}
