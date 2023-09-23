package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068_s {

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        visited = new boolean[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            } else {
                root = i;
            }
        }

        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(answer);
        }
    }

    private static void dfs(int n) {
        visited[n] = true;
        int childNode = 0;

        for (int node : tree[n]) { //자식 노드가 있으면 자식 노드 탐색
            if (!visited[node] && node != deleteNode) { //삭제 노드를 만나면 탐색 중단
                childNode++;
                dfs(node);
            }
        }

        if (childNode == 0) { //자식 노드가 없으면 answer 증가
            answer++;
        }
    }

}
