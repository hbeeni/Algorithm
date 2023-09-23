package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1068 {

    static List<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                list.get(parent).add(i);
            }
        }

        int node = Integer.parseInt(br.readLine());
        dfs(node);
        for (int i = 0; i < n; i++) {
            if (!visited[i] && list.get(i).contains(node)) {
                list.get(i).remove(Integer.valueOf(node));
                break;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && list.get(i).size() == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int n) {
        visited[n] = true;

        for (int node : list.get(n)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

}
